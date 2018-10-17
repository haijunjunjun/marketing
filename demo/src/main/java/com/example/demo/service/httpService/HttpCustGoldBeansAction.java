package com.example.demo.service.httpService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.example.demo.constant.HttpConnectionUrl;
import com.example.demo.model.http.HttpCustGoldBeansDetail;
import com.example.demo.model.http.HttpCustGoldBeansDetailModel;
import com.example.demo.model.http.HttpCustGoldBeansModel;
import com.example.demo.util.MessageInfo;
import com.example.demo.util.MessageInfoV3;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 09 - 28 - 16:25
 */
@Service
public class HttpCustGoldBeansAction {

    public MessageInfoV3<HttpCustGoldBeansDetailModel> getUserGoldBeansDetail(String phone) throws Exception {
        MessageInfoV3<HttpCustGoldBeansDetailModel> listMessageInfo = new MessageInfoV3<>();
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
        HttpCustGoldBeansDetailModel data = new HttpCustGoldBeansDetailModel();
        try {
            HttpCustGoldBeansModel httpCustGoldBeansModel = JSON.parseObject(stringBuffer.toString(), HttpCustGoldBeansModel.class);
            if (!Objects.isNull(httpCustGoldBeansModel.getData())){
                data = httpCustGoldBeansModel.getData();
                List<HttpCustGoldBeansDetail> logList = data.getLogList();
                logList.stream().forEach(h->{
                    if (h.getOtayonii() > 0){
                        h.setRealOtayonii("+"+h.getOtayonii());
                    }
//                    if (h.getOtayonii() < 0){
//                        h.setRealOtayonii("-"+h.getOtayonii());
//                    }
                });
                data.setLogList(logList);
                listMessageInfo.setData(data);
                listMessageInfo.setCode("200");
                listMessageInfo.setContent("金豆记录获取成功");
            }else {
                listMessageInfo.setCode("40002");
                listMessageInfo.setContent("该用户暂无记录");
            }
        } catch (JSONException e) {
            listMessageInfo.setCode("40003");
            listMessageInfo.setContent("系统异常");
        }
        return listMessageInfo;
    }
}
