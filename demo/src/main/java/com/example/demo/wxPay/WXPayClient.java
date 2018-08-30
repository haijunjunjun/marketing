package com.example.demo.wxPay;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

@Slf4j
public class WXPayClient extends WXPay {

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS5Padding";
    /**
     * 用户支付中，需要输入密码
     */
    private static final String ERR_CODE_USERPAYING = "USERPAYING";
    private static final String ERR_CODE_AUTHCODEEXPIRE = "AUTHCODEEXPIRE";
    /**
     * 交易状态: 未支付
     */
    private static final String TRADE_STATE_NOTPAY = "NOTPAY";

    /**
     * 用户输入密码，尝试30秒内去查询支付结果
     */
    private static Integer remainingTimeMs = 10000;

    private WXPayConfig config;

    public WXPayClient(WXPayConfig config, WXPayConstants.SignType signType, boolean useSandbox) {
        super(config, signType, useSandbox);
    }

    /**
     * 从request的inputStream中获取参数
     *
     * @param request
     * @return
     * @throws Exception
     */
    public Map<String, String> getNotifyParameter(HttpServletRequest request) throws Exception {
        InputStream inputStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, length);
        }
        outSteam.close();
        inputStream.close();

        // 获取微信调用我们notify_url的返回信息
        String resultXml = new String(outSteam.toByteArray(), "utf-8");
        Map<String, String> notifyMap = WXPayUtil.xmlToMap(resultXml);

        return notifyMap;
    }
}
