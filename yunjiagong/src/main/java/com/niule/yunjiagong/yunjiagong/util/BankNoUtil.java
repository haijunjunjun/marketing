package com.niule.yunjiagong.yunjiagong.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author haijun
 * @create 2018 - 09 - 30 - 10:44
 */
public class BankNoUtil {

    public static String hideCardNo(String cardNo) {
        if(StringUtils.isBlank(cardNo)) {
            return cardNo;
        }
        int length = cardNo.length();
        int beforeLength = 4;
        int afterLength = 4;
        //替换字符串，当前使用“*”
        String replaceSymbol = "*";
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<length; i++) {
            if(i < beforeLength || i >= (length - afterLength)) {
                sb.append(cardNo.charAt(i));
            } else {
                sb.append(replaceSymbol);
            }
        }

        return sb.toString();
    }
}
