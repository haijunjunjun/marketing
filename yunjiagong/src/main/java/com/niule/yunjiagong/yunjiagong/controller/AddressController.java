package com.niule.yunjiagong.yunjiagong.controller;

import com.niule.yunjiagong.yunjiagong.dal.model.Address;
import com.niule.yunjiagong.yunjiagong.model.AddrModel;
import com.niule.yunjiagong.yunjiagong.model.CityModel;
import com.niule.yunjiagong.yunjiagong.model.PageParamModel;
import com.niule.yunjiagong.yunjiagong.model.ProvinceModel;
import com.niule.yunjiagong.yunjiagong.service.AddressService;
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
 * @create 2018 - 07 - 24 - 10:50
 */
@Description("城市列表相关信息")
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Description("城市列表信息获取")
    @RequestMapping(value = "/user/address", method = RequestMethod.POST)
    public DataResponse getAddressPageInfo(@Valid @RequestBody(required = true) PageParamModel pageParamModel) {
        return DataResponse.success(addressService.getAddressList(pageParamModel.getPageNum(), pageParamModel.getPageSize()));
    }

    @Description("城市列表信息添加")
    @RequestMapping(value = "/user/address/add", method = RequestMethod.POST)
    public DataResponse addAddressInfo(@Valid @RequestBody(required = true) Address address) {
        return addressService.addAddress(address);
    }

    @Description("城市列表信息删除")
    @RequestMapping(value = "/user/address/delete", method = RequestMethod.POST)
    public DataResponse deleteAddressInfo(@Valid @RequestBody(required = true) AddrModel addrModel) {
        return addressService.deleteAddress(addrModel.getAddrId());
    }

    @Description("城市列表信息编辑")
    @RequestMapping(value = "/user/address/edit", method = RequestMethod.POST)
    public DataResponse editAddressInfo(@Valid @RequestBody(required = true) Address address) {
        return addressService.editAddress(address);
    }

    @Description("获取省份信息")
    @RequestMapping(value = "/user/province", method = RequestMethod.GET)
    public DataResponse getProvince() {
        return DataResponse.success(addressService.getProvince());
    }

    @Description("获取城市信息")
    @RequestMapping(value = "/user/city", method = RequestMethod.POST)
    public DataResponse getCity(@Valid @NotNull @RequestBody(required = true) ProvinceModel provinceModel) {
        return DataResponse.success(addressService.getCity(provinceModel.getProvinceId()));
    }

    @Description("获取区域信息")
    @RequestMapping(value = "/user/area", method = RequestMethod.POST)
    public DataResponse getArea(@Valid @NotNull @RequestBody(required = true) CityModel cityModel) {
        return DataResponse.success(addressService.getArea(cityModel.getCityId()));
    }

    @Description("加工厂地域")
    @RequestMapping(value = "/user/factory/area", method = RequestMethod.POST)
    public DataResponse getFactoryArea() {
        return DataResponse.success(addressService.getFactoryArea());
    }
}
