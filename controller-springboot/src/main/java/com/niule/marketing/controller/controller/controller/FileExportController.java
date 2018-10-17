package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.service.FileExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 10 - 11 - 15:58
 */
@RestController
public class FileExportController {

    @Autowired
    private FileExportService fileExportService;

    @ResponseBody
    @Description("获取客户数据文件")
    @RequestMapping(value = "/fetch/cust/info/per/day", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
    public DataResponse fetchCustInfoPerDay(HttpServletResponse response,
                                            @Valid @NotNull @RequestParam("startTime") String startTime,
                                            @Valid @NotNull @RequestParam("endTime") String endTime) throws Exception {
        return DataResponse.success(fileExportService.excelFile(response, startTime, endTime));
    }
}
