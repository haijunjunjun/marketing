package com.niule.marketing.controller.controller.service;

import com.niule.marketing.controller.controller.dal.mapper.define.CustomerPerDayResponseMapper;
import com.niule.marketing.controller.controller.dal.model.define.CustomerPerDayResponse;
import com.niule.marketing.controller.controller.model.ExcelData;
import com.niule.marketing.controller.controller.util.DateUtils;
import com.niule.marketing.controller.controller.util.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 10 - 11 - 15:58
 */
@Slf4j
@Service
public class FileExportService {

    @Autowired
    private CustomerPerDayResponseMapper customerPerDayResponseMapper;

    public String excelFile(HttpServletResponse response, String startTime, String endTime) throws Exception {
        ExcelData excelData = new ExcelData();
        excelData.setName("获取客户信息");
        List<String> titles = new ArrayList<>();
        titles.add("销售人员名称");
        titles.add("公司名称");
        titles.add("公司类型");
        titles.add("客户名称");
        titles.add("客户手机号");
        titles.add("客户地址");
        titles.add("报备时间");
        titles.add("备注");
        excelData.setTitles(titles);
        List<List<Object>> rows = new ArrayList<>();
        List<CustomerPerDayResponse> perDayCustomerInfo = customerPerDayResponseMapper.getPerDayCustomerInfo(startTime, endTime);
        for (CustomerPerDayResponse c : perDayCustomerInfo) {
            List<Object> data = new ArrayList<>();
            data.add(c.getUserRealName());
            data.add(c.getCompanyName());
            data.add(c.getCompanyType());
            data.add(c.getCustName());
            data.add(c.getCustPhone());
            data.add(c.getCustAddr());
            data.add(DateUtils.dateFormatV2(c.getRepoTime()));
            data.add(c.getMark());
            rows.add(data);
        }

        excelData.setRows(rows);

//        String path = "C://Users/admin/Desktop";
//        File file = new File(path+"/cust-data-"+startTime+"-"+endTime+".xlsx");
//        if (!file.getParentFile().exists()) {
//            file.getParentFile().mkdirs();
//        }
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        ExcelUtils.exportExcel(excelData,fileOutputStream);
//        fileOutputStream.close();

        String fileName = "cust-data-" + startTime + "-" + endTime + ".xlsx";
        ExcelUtils.exportExcel(response, fileName, excelData);

        return "success";
    }
}
