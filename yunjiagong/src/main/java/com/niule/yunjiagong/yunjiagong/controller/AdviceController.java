package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.model.AdviceRequestModel;
import com.niule.yunjiagong.yunjiagong.service.AdviceService;
import com.niule.yunjiagong.yunjiagong.util.CodeResponse;
import com.niule.yunjiagong.yunjiagong.util.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 09 - 29 - 14:53
 */
@RestController
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @Description("用户意见反馈")
    @RequestMapping(value = "/user/advice/response",method = RequestMethod.POST)
    public DataResponse userAdviceResponse (@Valid @NotNull @RequestBody(required = true)AdviceRequestModel adviceRequestModel){
        String result = adviceService.submitAdvice(adviceRequestModel);
        if ("success".equals(result)){
            return DataResponse.success("提交成功");
        }
        return DataResponse.error(new CodeResponse(4000100,result));
    }
}
