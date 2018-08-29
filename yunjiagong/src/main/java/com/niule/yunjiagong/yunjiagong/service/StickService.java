package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.AreaMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.CityMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.ProvinceMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.StickPriceSettingMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.City;
import com.niule.yunjiagong.yunjiagong.dal.model.Province;
import com.niule.yunjiagong.yunjiagong.dal.model.StickPriceSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author haijun
 * @create 2018 - 08 - 24 - 17:01
 */
@Service
public class StickService {

    @Autowired
    private StickPriceSettingMapper stickPriceSettingMapper;
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private AreaMapper areaMapper;

    public Long getPrice(String addressDetail, String address) {
        long finalStickPrice = 0l;
        if (!StringUtils.isEmpty(addressDetail)) {
            String[] addr = addressDetail.trim().split(",");
            String levelStr = "";
            Integer areaTag = 0;
            Integer areaCount = 0;
            for (int i = 0; i < addr.length; i++) {
                if (addr[i].contains(address)) {
                    areaTag = i + 1;
                    break;
                }
            }
            switch (areaTag) {
                case 1:
                    switch (addr[0]) {
                        case "北京":
                            levelStr = "LEVEL5_BEIJING";
                            break;
                        case "上海":
                            levelStr = "LEVEL5_SHANGHAI";
                            break;
                        case "天津":
                            levelStr = "LEVEL5_TIANJIN";
                            break;
                        case "重庆":
                            levelStr = "LEVEL5_CHONGQING";
                            break;
                        case "香港":
                            levelStr = "LEVEL4_BASE";
                            break;
                        case "澳门":
                            levelStr = "LEVEL4_BASE";
                            break;
                        case "台湾":
                            levelStr = "LEVEL4_BASE";
                            break;
                        default:
                            levelStr = "LEVEL3_BASE";
                            break;
                    }
                    switch (levelStr) {
                        case "LEVEL3_BASE":
                            Province provinceByName = provinceMapper.getProvinceByName(addr[0]);
                            List<Integer> cityIds = cityMapper.getCity(provinceByName.getId()).stream().map(City::getId).collect(Collectors.toList());
                            areaCount = areaMapper.getAreaByCityIds(cityIds, "市辖区");
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    levelStr = "LEVEL2_BASE";
                    City cityByName = cityMapper.getCityByName(addr[1]);
                    areaCount = areaMapper.getAreaByCityId(cityByName.getId(), "市辖区");
                    break;
                case 3:
                    levelStr = "LEVEL1_BASE";
                    areaCount = 1;
                    break;
                default:
                    break;
            }
            StickPriceSetting stickPriceSetting = new StickPriceSetting();
            stickPriceSetting.setSign(levelStr);
            StickPriceSetting stickPriceSettingInfo = stickPriceSettingMapper.selectOne(stickPriceSetting);
            //获取折扣
            Long discountvalue = stickPriceSettingInfo.getDiscountvalue();
            //获取县级单价
            StickPriceSetting stickPriceSettingV1 = new StickPriceSetting();
            stickPriceSettingV1.setSign("LEVEL1_BASE");
            StickPriceSetting stickPriceSettingInfoV1 = stickPriceSettingMapper.selectOne(stickPriceSettingV1);
            Long unitValue = stickPriceSettingInfoV1.getValue();
            if ("LEVEL1_BASE".equals(levelStr) || "LEVEL4_BASE".equals(levelStr) || "LEVEL5_BASE".equals(levelStr)
                    || "LEVEL5_BEIJING".equals(levelStr) || "LEVEL5_SHANGHAI".equals(levelStr) || "LEVEL5_TIANJIN".equals(levelStr) || "LEVEL5_CHONGQING".equals(levelStr)) {
                finalStickPrice = stickPriceSettingInfo.getValue();
            } else {
                finalStickPrice =
                        stickPriceSettingInfo.getValue() >= areaCount * unitValue * discountvalue / 100
                                ? stickPriceSettingInfo.getValue()
                                : areaCount * unitValue * discountvalue / 100;
            }
        } else {
            StickPriceSetting stickPriceSetting = new StickPriceSetting();
            stickPriceSetting.setSign("LEVEL2_BASE");
            StickPriceSetting stickPriceSettingInfoV3 = stickPriceSettingMapper.selectOne(stickPriceSetting);
            finalStickPrice = stickPriceSettingInfoV3.getValue();
        }
        return finalStickPrice;
    }
}
