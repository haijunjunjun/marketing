package com.niule.yunjiagong.yunjiagong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niule.yunjiagong.yunjiagong.dal.mapper.AddressMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.AreaMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.CityMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.ProvinceMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Address;
import com.niule.yunjiagong.yunjiagong.dal.model.Area;
import com.niule.yunjiagong.yunjiagong.dal.model.City;
import com.niule.yunjiagong.yunjiagong.dal.model.Province;
import com.niule.yunjiagong.yunjiagong.model.cloud.UserBaseInfo;
import com.niule.yunjiagong.yunjiagong.service.cloud.UserInfoFeginService;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 07 - 24 - 10:25
 */
@Slf4j
@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private UserInfoFeginService userInfoFeginService;

    public PageInfo<Address> getAddressList(Integer pageNum, Integer pageSize) {
        UserBaseInfo userBaseInfo = userInfoFeginService.getOperator().getData();
        if (Objects.isNull(userBaseInfo)) {
            throw new BizRuntimeException("系統信息異常！");
        }
        PageHelper.startPage(pageNum == null ? 1 : pageNum, pageSize == null ? 5 : pageSize);
        List<Address> addresses = addressMapper.getAddressList(userBaseInfo.getId().intValue(), 1);
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

    public List<City> getCity(Integer provinceId) {
        if (StringUtils.isEmpty(provinceId)) {
            log.info("参数信息异常！");
            throw new BizRuntimeException("参数信息异常!");
        }
        List<City> city = cityMapper.getCity(provinceId);
        if (Objects.isNull(city)) {
            log.info("数据库信息异常!");
            throw new BizRuntimeException("数据库信息异常!");
        }
        return city;
    }

    public List<Area> getArea(Integer cityId) {
        if (StringUtils.isEmpty(cityId.toString())) {
            log.info("参数信息异常！");
            throw new BizRuntimeException("参数信息异常！");
        }
        List<Area> area = areaMapper.getArea(cityId);
        if (Objects.isNull(area)) {
            log.info("数据库信息异常！");
            throw new BizRuntimeException("数据库信息异常！");
        }
        return area;
    }
}
