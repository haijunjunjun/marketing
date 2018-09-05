package com.example.demo.service.httpService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.constant.HttpConnectionUrl;
import com.example.demo.model.http.HttpDataModel;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/**
 * @author haijun
 * @create 2018 - 08 - 31 - 17:21
 */
@Service
public class ValidUserRegistService {

    public String validUserRegist(String phone) throws Exception {
        String urlStr = HttpConnectionUrl.YUNJIAGONG.getUrl() + "/userManagerController/checkUserRegistered?mobile="+phone;
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
        HttpDataModel httpDataModel = JSON.parseObject(stringBuffer.toString(), HttpDataModel.class);
        System.out.println("data is :"+httpDataModel.isData());
        return stringBuffer.toString();
    }
}
