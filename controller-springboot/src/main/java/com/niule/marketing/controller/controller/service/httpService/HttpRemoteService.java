package com.niule.marketing.controller.controller.service.httpService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.niule.marketing.controller.controller.constant.HttpConnectionUrl;
import com.niule.marketing.controller.controller.model.HttpCustGoldBeansDetail;
import com.niule.marketing.controller.controller.model.HttpCustGoldBeansModel;
import com.niule.marketing.controller.controller.model.HttpCustRegistInfoModel;
import com.niule.marketing.controller.controller.util.ListPageUtil;
import com.niule.marketing.controller.controller.util.MessageInfo;
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
 * @create 2018 - 08 - 31 - 17:21
 */
@Service
public class HttpRemoteService {

    public HttpCustRegistInfoModel getUserRegistInfo(String phone) throws Exception {
        String urlStr = HttpConnectionUrl.YUNJIAGONG.getUrl() + "/userManagerController/checkUserRegistered?mobile=" + phone;
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
        HttpCustRegistInfoModel httpCustRegistTimeModel = JSON.parseObject(stringBuffer.toString(), HttpCustRegistInfoModel.class);
        return httpCustRegistTimeModel;
    }

    public MessageInfo<ListPageUtil<HttpCustGoldBeansDetail>> getUserGoldBeansDetail(String phone, Integer pageNum, Integer pageSize) throws Exception {
        MessageInfo<ListPageUtil<HttpCustGoldBeansDetail>> listMessageInfo = new MessageInfo<>();
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
            if ("true".equals(httpCustGoldBeansModel.getSuccess()) && !Objects.isNull(httpCustGoldBeansModel.getData())){
                data = httpCustGoldBeansModel.getData().getLogList();
                ListPageUtil<HttpCustGoldBeansDetail> httpCustGoldBeansDetailListPageUtil = new ListPageUtil<>(data, pageNum, pageSize);
                httpCustGoldBeansDetailListPageUtil.setData(httpCustGoldBeansDetailListPageUtil.getPagedList());
                listMessageInfo.setData(httpCustGoldBeansDetailListPageUtil);
                listMessageInfo.setResult("success");
            }else {
                listMessageInfo.setResult(httpCustGoldBeansModel.getMessage());
            }
        } catch (JSONException e) {
            listMessageInfo.setResult("解析异常");
        }
        return listMessageInfo;
    }
}
