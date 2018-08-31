package com.example.demo.service;

import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.example.cache.rediscache.util.PayStatus;
import com.example.cache.rediscache.util.PayUtil;
import com.example.demo.config.aliPay.AliPayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author haijun
 * @create 2018 - 08 - 28 - 10:50
 */
@Service
public class AliPayServiceV1 {

    @Autowired
    private AliPayConfig aliPayConfig;

    //支付宝支付
    public String aliPayPrecreate() throws Exception {
        Integer custId = 1;
        String outTradeNo = custId.toString() + System.currentTimeMillis();
        String totalFee = "0.01";
        String body = "客户" + custId + "支付:" + totalFee;
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
        request.setNotifyUrl("");
        AlipayTradePrecreateResponse response = defaultAlipayClient.execute(request);
        System.out.println("response is :" + response.toString());
        System.out.println("response getBody is :" + response.getBody() + "----response getCode is :" + response.getCode());
        System.out.println("response getParams is :" + response.getBody() + "----" + response.getParams());
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
            return png_base64;
        } else if (PayStatus.PAY_FAIL.getCode().equals(response.getCode())) {
            return "支付失败";
        } else if (PayStatus.WAIT_PAY.getCode().equals(response.getCode())) {
            return "等待用户付款";
        } else if (PayStatus.UNKNOWN.getCode().equals(response.getCode())) {
            return "未知异常";
        }
        return null;
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
        System.out.println("params is :" + params);
        String tradeStatus = request.getParameter("trade_status");
        boolean flag = AlipaySignature.rsaCheckV1(params, aliPayConfig.getAliPayPublic(), aliPayConfig.getCharset(), aliPayConfig.getSignType());
        if (flag) {//验证成功

            if (tradeStatus.equals("TRADE_FINISHED") || tradeStatus.equals("TRADE_SUCCESS")) {
                // TODO: 2018/8/28 执行逻辑
            }
            return "success";
        } else {//验证失败
            System.out.println("验证失败");
            return "fail";
        }
    }
}
