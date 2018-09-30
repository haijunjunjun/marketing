package com.example.demo.service.httpService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.example.demo.constant.HttpConnectionUrl;
import com.example.demo.model.http.HttpCustGoldBeansDetail;
import com.example.demo.model.http.HttpCustGoldBeansModel;
import com.example.demo.util.MessageInfo;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 28 - 16:25
 */
@Service
public class HttpCustGoldBeansAction {

    public MessageInfo<List<HttpCustGoldBeansDetail>> getUserGoldBeansDetail(String phone) throws Exception {
        MessageInfo<List<HttpCustGoldBeansDetail>> listMessageInfo = new MessageInfo<>();
        String urlStr = HttpConnectionUrl.YUNJIAGONG.getUrl() + "/logManagerController/getBeanLogListByMobile?mobile=" + phone;
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
        List<HttpCustGoldBeansDetail> data = new ArrayList<>();
        try {
            HttpCustGoldBeansModel httpCustGoldBeansModel = JSON.parseObject(stringBuffer.toString(), HttpCustGoldBeansModel.class);
            data = httpCustGoldBeansModel.getData();
            listMessageInfo.setData(data);
            listMessageInfo.setContent("success");
        } catch (JSONException e) {
            listMessageInfo.setContent("fail");
        }
        return listMessageInfo;
    }
}
