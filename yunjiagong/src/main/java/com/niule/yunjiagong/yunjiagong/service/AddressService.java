package com.niule.yunjiagong.yunjiagong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niule.yunjiagong.yunjiagong.dal.mapper.AddressMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.ProvinceMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Address;
import com.niule.yunjiagong.yunjiagong.dal.model.City;
import com.niule.yunjiagong.yunjiagong.dal.model.Province;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 07 - 24 - 10:25
 */
@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ProvinceMapper provinceMapper;

    public PageInfo<Address> getAddressList(Integer userId, Integer userType, Integer pageNum, Integer pageSize) {
        if (StringUtils.isEmpty(userId.toString()) || StringUtils.isEmpty(userType)) {
            throw new BizRuntimeException("系統信息異常！");
        }
        PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 5 : pageSize);
        List<Address> addresses = addressMapper.getAddressList(userId, userType);
        PageInfo<Address> addressPageInfo = new PageInfo<>(addresses);
        return addressPageInfo;
    }

    public List<Province> getProvince() {
        List<Province> province = provinceMapper.getProvince();
        if (Objects.isNull(province)) {
            throw new BizRuntimeException("数据库信息查询异常!");
        }
        return province;
    }

    public List<City> getCity() {
        return null;
    }
}
