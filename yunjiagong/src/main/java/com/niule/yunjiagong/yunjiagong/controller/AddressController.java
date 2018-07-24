package com.niule.yunjiagong.yunjiagong.controller;

import com.github.pagehelper.PageInfo;
import com.niule.yunjiagong.yunjiagong.dal.model.Address;
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
    public ResponseEntity<PageInfo<Address>> getAddressPageInfo(@Valid @NotNull @RequestParam("pageSize") Integer pageSize,
                                                                @Valid @NotNull @RequestParam("pageNum") Integer pageNum) {
        return ResponseEntity.ok(addressService.getAddressList(pageSize, pageNum));
    }
}
