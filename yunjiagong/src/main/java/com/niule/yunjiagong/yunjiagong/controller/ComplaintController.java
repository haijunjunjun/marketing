package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.ComplaintModel;
import com.niule.yunjiagong.yunjiagong.service.ComplaintService;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 07 - 26 - 16:18
 */
@RestController
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping(value = "/user/complaint", method = RequestMethod.POST)
    public DataResponse complaint(@Valid @NotNull @RequestBody(required = true) ComplaintModel complaintModel) {
        return DataResponse.success(complaintService.doComplaint(complaintModel));
    }
}
