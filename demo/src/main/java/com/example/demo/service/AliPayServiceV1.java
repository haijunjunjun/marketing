package com.example.demo.service;

import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.example.demo.config.aliPay.AliPayConfig;
import com.example.demo.dal.mapper.AlipayRecordMapper;
import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.mapper.UserPerformanceMapper;
import com.example.demo.dal.model.AlipayRecord;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.model.UserPerformance;
import com.example.demo.model.AliPayResponseModel;
import com.example.demo.util.AliPayMessageInfo;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.PayStatus;
import com.example.demo.util.PayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author haijun
 * @create 2018 - 08 - 28 - 10:50
 */
@Slf4j
@Service
public class AliPayServiceV1 {

    @Autowired
    private AliPayConfig aliPayConfig;
    @Autowired
    private CustomerInfoMapper customerInfoMapper;
    @Autowired
    private AlipayRecordMapper alipayRecordMapper;
    @Autowired
    private UserPerformanceMapper userPerformanceMapper;

    //支付宝支付
    public AliPayMessageInfo<String> aliPayPrecreate(Integer custId) throws Exception {
        AliPayMessageInfo<String> messageInfo = new AliPayMessageInfo<>();
        CustomerInfo customerInfo = customerInfoMapper.selectByPrimaryKey(custId);
        if (Objects.isNull(customerInfo)) {
            log.info("参数信息异常!");
            throw new BizRuntimeException("参数信息异常!");
        }
        String outTradeNo = custId.toString() + System.currentTimeMillis();
        String totalFee = new BigDecimal(customerInfo.getPrice().toString()).setScale(2, BigDecimal.ROUND_HALF_DOWN).toString();
        String body = "客户" + customerInfo.getCustName() + "支付:" + totalFee;
        String subject = "支付宝扫码支付";
        String timeOutExpress = "90m";

        DefaultAlipayClient defaultAlipayClient = new DefaultAlipayClient(aliPayConfig.getUrl(), aliPayConfig.getAppId(), aliPayConfig.getRsaPrivate(),
                aliPayConfig.getFormat(), aliPayConfig.getCharset(), aliPayConfig.getAliPayPublic(), aliPayConfig.getSignType());
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":\"" + outTradeNo + "\"," +
                "    \"total_amount\":\"" + totalFee + "\"," +
                "    \"body\":\"" + body + "\"," +
                "    \"subject\":\"" + subject + "\"," +
                "    \"timeout_express\":\"" + timeOutExpress + "\"}");//设置业务参数
        request.setNotifyUrl("http://crm.yunjg.net:8090/market/ali/pay/notify");
        AlipayTradePrecreateResponse response = defaultAlipayClient.execute(request);
        System.out.println("response is :" + response.toString());
        System.out.println("response getBody is :" + response.getBody() + "----response getCode is :" + response.getCode());
        System.out.println("response getParams is :" + response.getBody() + "----" + response.getParams());

        AlipayRecord alipayRecord = new AlipayRecord();
        alipayRecord.setCustId(custId);
        alipayRecord.setOutTradeNo(outTradeNo);
        alipayRecord.setPrePayCode(response.getCode());
        alipayRecord.setPrePayMessage(response.getMsg());
        alipayRecord.setTotalAmount(totalFee);
        alipayRecord.setSubject(subject);
        alipayRecord.setCreateTime(new Date());
        alipayRecordMapper.insert(alipayRecord);

        String png_base64;
        if ("Success".equals(response.getMsg()) && PayStatus.PAY_SUCCESS.getCode().equals(response.getCode())) {
            String qrcode = response.getQrCode();
            BufferedImage image = PayUtil.getQRCodeImge(qrcode);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
            ImageIO.write(image, "png", baos);//写入流中
            byte[] bytes = baos.toByteArray();//转换成字节
            BASE64Encoder encoder = new BASE64Encoder();
            png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
            png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
            messageInfo.setData(png_base64);
            messageInfo.setCode(PayStatus.PAY_SUCCESS.getCode());
            messageInfo.setMessage(PayStatus.PAY_SUCCESS.getMessage());
            return messageInfo;
        } else if (PayStatus.PAY_FAIL.getCode().equals(response.getCode())) {
            messageInfo.setCode(PayStatus.PAY_FAIL.getCode());
            messageInfo.setMessage(PayStatus.PAY_FAIL.getMessage());
            return messageInfo;
        } else if (PayStatus.WAIT_PAY.getCode().equals(response.getCode())) {
            messageInfo.setCode(PayStatus.WAIT_PAY.getCode());
            messageInfo.setMessage(PayStatus.WAIT_PAY.getMessage());
            return messageInfo;
        } else if (PayStatus.UNKNOWN.getCode().equals(response.getCode())) {
            messageInfo.setCode(PayStatus.UNKNOWN.getCode());
            messageInfo.setMessage(PayStatus.UNKNOWN.getMessage());
            return messageInfo;
        }
        messageInfo.setCode("44440");
        messageInfo.setMessage("程序信息异常,请联系客服人员!");
        return messageInfo;
    }

    //支付宝回调
    public String aliPayNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        System.out.println("params to string is :" + params.toString());
        System.out.println("params is :" + params);
        String tradeStatus = request.getParameter("trade_status");
        String totalAmount = request.getParameter("total_amount");
        String outTradeNo = params.get("out_trade_no");
        String tradeNo = params.get("trade_no");
        log.info("回调消息判断!");
        boolean flag = AlipaySignature.rsaCheckV1(params, aliPayConfig.getAliPayPublic(), aliPayConfig.getCharset(), aliPayConfig.getSignType());
        if (flag) {//验证成功
            AlipayRecord alipayRecord = new AlipayRecord();
            alipayRecord.setOutTradeNo(outTradeNo);
            AlipayRecord alipayRecordInfo = alipayRecordMapper.selectOne(alipayRecord);
            AlipayRecord alipayRecordV1 = new AlipayRecord();
            alipayRecordV1.setId(alipayRecordInfo.getId());
            alipayRecordV1.setTradeNo(tradeNo);
            alipayRecordV1.setModifyTime(new Date());
            if (tradeStatus.equals("TRADE_FINISHED") || tradeStatus.equals("TRADE_SUCCESS")) {
                alipayRecordV1.setPayStatus("SUCCESS_PAY");
                alipayRecordMapper.updateByPrimaryKeySelective(alipayRecordV1);
                CustomerInfo customerInfo = new CustomerInfo();
                customerInfo.setId(alipayRecordInfo.getCustId());
                customerInfo.setIsMoney(1);
                customerInfoMapper.updateByPrimaryKeySelective(customerInfo);

                UserPerformance userPerformance = new UserPerformance();
                CustomerInfo customerInfoV2 = customerInfoMapper.selectByPrimaryKey(alipayRecordInfo.getCustId());
                userPerformance.setCustId(customerInfoV2.getId());
                userPerformance.setUserId(customerInfoV2.getUserId());
                userPerformance.setCreateTime(new Date());
                userPerformance.setModifyTime(new Date());
                userPerformance.setPerformance(new BigDecimal(totalAmount).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue());
                int insert = userPerformanceMapper.insert(userPerformance);
                if (1 != insert) {
                    log.info("业绩保存异常！");
                }
                log.info("回调成功···");
                responseBody(response, "回调成功");
            }
            System.out.println("success");
            return "success";
        } else {//验证失败
            responseBody(response, "签名验证失败!");
            System.out.println("签名验证失败!");
            return "fail";
        }
    }

    private void responseBody(HttpServletResponse response, String contentBody) {
        try {
            response.setContentType("type=text/html;charset=UTF-8");
            String s = contentBody;
            response.getWriter().write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public AliPayResponseModel aliPayResponse(String outTradeNo) {
        AliPayResponseModel aliPayResponseModel = new AliPayResponseModel();
        if (StringUtils.isEmpty(outTradeNo)) {
            log.info("tradeNo   参数信息异常!");
            throw new BizRuntimeException("tradeNo   参数信息异常!");
        }
        AlipayRecord alipayRecord = new AlipayRecord();
        alipayRecord.setOutTradeNo(outTradeNo);
        AlipayRecord alipayRecordInfo = alipayRecordMapper.selectOne(alipayRecord);
        if (!Objects.isNull(alipayRecordInfo)) {
            if (!StringUtils.isEmpty(alipayRecordInfo.getPayStatus())) {
                aliPayResponseModel.setPayStatus(alipayRecordInfo.getPayStatus().trim());
            }
        }
        return aliPayResponseModel;
    }
}
