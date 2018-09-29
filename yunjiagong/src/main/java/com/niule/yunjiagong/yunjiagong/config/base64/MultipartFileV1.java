package com.niule.yunjiagong.yunjiagong.config.base64;

import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * @author haijun
 * @create 2018 - 08 - 13 - 18:15
 */
public class MultipartFileV1 {

    public static BASE64DecodedMultipartFile base64ToMultipart(String base64) {
        try {
            String[] baseStrs = base64.split(",");

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = new byte[0];
            b = decoder.decodeBuffer(baseStrs[1]);

            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            return new BASE64DecodedMultipartFile(b, baseStrs[0]);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
