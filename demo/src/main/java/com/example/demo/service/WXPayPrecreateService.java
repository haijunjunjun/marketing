package com.example.demo.service;

import com.example.demo.dal.mapper.CustomerInfoMapper;
import com.example.demo.dal.mapper.PayRecordMapper;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.dal.model.PayRecord;
import com.example.demo.util.BizRuntimeException;
import com.example.demo.util.PayUtil;
import com.example.demo.wxPay.WXPayClient;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class WXPayPrecreateService {

    @Autowired
    private WXPay wxPay;
    @Autowired
    private WXPayClient wxPayClient;
    @Autowired
    private PayRecordMapper payRecordMapper;
    @Autowired
    private CustomerInfoMapper customerInfoMapper;

    /**
     * 扫码支付 - 统一下单
     * 相当于支付的电脑网站支付
     *
     * <a href="https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1">扫码支付API</a>
     */
    public void precreate(HttpServletRequest request, HttpServletResponse response, Integer custId) throws Exception {
        PayRecord payRecord = new PayRecord();
        CustomerInfo customerInfo = customerInfoMapper.selectByPrimaryKey(custId);
        if (Objects.isNull(customerInfo)) {
            log.info("参数信息异常!");
            throw new BizRuntimeException("参数信息异常!");
        }
        Map<String, String> reqData = new HashMap<>();
        reqData.put("out_trade_no", String.valueOf(System.nanoTime()) + custId);
        reqData.put("trade_type", "NATIVE");
        reqData.put("product_id", "66");
        reqData.put("body", customerInfo.getCustName() + "客户下单");
        // 订单总金额，单位为分
        reqData.put("total_fee", customerInfo.getPrice().toString());
        // APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
        reqData.put("spbill_create_ip", "192.168.105.75");
        // 异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
        reqData.put("notify_url", "http://localhost:8089/wxpay/precreate/marketing/wx/pay/notify");
        // 自定义参数, 可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
        reqData.put("device_info", "device");
        // 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用。
        reqData.put("attach", "success");
        /**
         * {
         * code_url=weixin://wxpay/bizpayurl?pr=vvz4xwC,
         * trade_type=NATIVE,
         * return_msg=OK,
         * result_code=SUCCESS,
         * return_code=SUCCESS,
         * prepay_id=wx18111952823301d9fa53ab8e1414642725
         * }
         */
        Map<String, String> responseMap = wxPay.unifiedOrder(reqData);
        log.info("支付响应信息:" + responseMap.toString());
        String returnCode = responseMap.get("return_code");
        String resultCode = responseMap.get("result_code");

        payRecord.setOutTradeNo(reqData.get("out_trade_no"));
        payRecord.setTradeType(reqData.get("trade_type"));
        payRecord.setProductId(reqData.get("product_id"));
        payRecord.setBody(reqData.get("body"));
        payRecord.setTotalFee(reqData.get("total_fee"));
        payRecord.setSpbillCreateIp(reqData.get("spbill_create_ip"));
        payRecord.setReturnCode(returnCode);
        payRecord.setResultCode(resultCode);

        if (WXPayConstants.SUCCESS.equals(returnCode) && WXPayConstants.SUCCESS.equals(resultCode)) {
            String prepayId = responseMap.get("prepay_id");
            String codeUrl = responseMap.get("code_url");

            BufferedImage image = PayUtil.getQRCodeImge(codeUrl);

            response.setContentType("image/jpeg");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setIntHeader("Expires", -1);
            ImageIO.write(image, "JPEG", response.getOutputStream());

            payRecord.setCodeUrl(codeUrl);
            payRecord.setPrepayId(prepayId);
        }
        payRecordMapper.insert(payRecord);
    }

    public void precreateNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> reqData = wxPayClient.getNotifyParameter(request);
        /**
         * {
         * transaction_id=4200000138201806180751222945,
         * nonce_str=aaaf3fe4d3aa44d8b245bc6c97bda7a8,
         * bank_type=CFT,
         * openid=xxx,
         * sign=821A5F42F5E180ED9EF3743499FBCF13,
         * fee_type=CNY,
         * mch_id=xxx,
         * cash_fee=1,
         * out_trade_no=186873223426017,
         * appid=xxx,
         * total_fee=1,
         * trade_type=NATIVE,
         * result_code=SUCCESS,
         * time_end=20180618131247,
         * is_subscribe=N,
         * return_code=SUCCESS
         * }
         */
        log.info("支付结果异步通知响应信息：" + reqData.toString());
        boolean signatureValid = wxPay.isPayResultNotifySignatureValid(reqData);
        if (signatureValid) {
            /**
             * 注意：同样的通知可能会多次发送给商户系统。商户系统必须能够正确处理重复的通知。
             * 推荐的做法是，当收到通知进行处理时，首先检查对应业务数据的状态，
             * 判断该通知是否已经处理过，如果没有处理过再进行处理，如果处理过直接返回结果成功。
             * 在对业务数据进行状态检查和处理之前，要采用数据锁进行并发控制，以避免函数重入造成的数据混乱。
             */
            String tradeNo = reqData.get("out_trade_no");
            PayRecord payRecord = new PayRecord();
            payRecord.setOutTradeNo(tradeNo);
            PayRecord payRecord1 = payRecordMapper.selectOne(payRecord);
            PayRecord payRecord2 = new PayRecord();
            payRecord2.setId(payRecord1.getId());
            payRecord2.setReturnMsg("success_pay");
            payRecord2.setPayResult("success");
            payRecordMapper.updateByPrimaryKeySelective(payRecord2);

            Map<String, String> responseMap = new HashMap<>(2);
            responseMap.put("return_code", "SUCCESS");
            responseMap.put("return_msg", "OK");
            String responseXml = WXPayUtil.mapToXml(responseMap);

            response.setContentType("text/xml");
            response.getWriter().write(responseXml);
            response.flushBuffer();
        }
    }
}
