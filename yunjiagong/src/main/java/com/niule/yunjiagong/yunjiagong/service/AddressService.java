package com.niule.yunjiagong.yunjiagong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niule.yunjiagong.yunjiagong.dal.mapper.AddressMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Address;
import com.niule.yunjiagong.yunjiagong.dal.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 24 - 10:25
 */
@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;

    public PageInfo<Address> getAddressList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 5 : pageSize);
        List<Address> addresses = addressMapper.selectAll();
        PageInfo<Address> addressPageInfo = new PageInfo<>(addresses);
        return addressPageInfo;
    }

    public List<Province> getProvince() {
        return null;
    }
}
