package com.niule.yunjiagong.yunjiagong.controller;

import com.github.pagehelper.PageInfo;
import com.niule.yunjiagong.yunjiagong.config.annotation.Operator;
import com.niule.yunjiagong.yunjiagong.dal.model.Address;
import com.niule.yunjiagong.yunjiagong.dal.model.Province;
import com.niule.yunjiagong.yunjiagong.model.CurOperator;
import com.niule.yunjiagong.yunjiagong.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 24 - 10:50
 */
@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Description("城市列表信息获取")
    @RequestMapping(value = "/user/address", method = RequestMethod.GET)
    public ResponseEntity<PageInfo<Address>> getAddressPageInfo(@Valid @NotNull @Operator CurOperator curOperator,
                                                                @Valid @RequestParam("pageSize") Integer pageSize,
                                                                @Valid @RequestParam("pageNum") Integer pageNum) {
        return ResponseEntity.ok(addressService.getAddressList(curOperator.getUserId(), curOperator.getUserType(), pageSize, pageNum));
    }

    @RequestMapping(value = "/user/province")
    public ResponseEntity<List<Province>> getProvince() {
        return ResponseEntity.ok(addressService.getProvince());
    }
}
