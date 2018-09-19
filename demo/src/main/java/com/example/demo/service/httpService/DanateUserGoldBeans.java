package com.example.demo.service.httpService;

import com.alibaba.fastjson.JSON;
import com.example.demo.constant.HttpConnectionUrl;
import com.example.demo.model.http.HttpDataModel;
import com.example.demo.model.http.HttpDonateUserGoldBeansResponseModel;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author haijun
 * @create 2018 - 09 - 13 - 17:21
 */
@Service
public class DanateUserGoldBeans {

    public HttpDonateUserGoldBeansResponseModel donateUserGoldBeans(String phone,Integer goldBeansNum) throws Exception {
        String urlStr = HttpConnectionUrl.YUNJIAGONG.getUrl() + "/userManagerController/beanGift?mobile="+phone+"&beanNumber="+goldBeansNum;
        URL url = new URL(urlStr);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.connect();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String line;
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }
        bufferedReader.close();
        httpURLConnection.disconnect();
//        System.out.println(bufferedReader.toString());
//        System.out.println(stringBuffer.toString());
//        System.out.println(Arrays.asList(stringBuffer.toString()));
        HttpDonateUserGoldBeansResponseModel httpDonateUserGoldBeansResponseModel = JSON.parseObject(stringBuffer.toString(), HttpDonateUserGoldBeansResponseModel.class);
        System.out.println("data is :"+httpDonateUserGoldBeansResponseModel.getData());
        return httpDonateUserGoldBeansResponseModel;
    }
}
