package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.AddressInfoMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.HotCityMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.IsChangeDataMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.AddressInfo;
import com.niule.yunjiagong.yunjiagong.dal.model.HotCity;
import com.niule.yunjiagong.yunjiagong.dal.model.IsChangeData;
import com.niule.yunjiagong.yunjiagong.model.AddressInfoModel;
import com.niule.yunjiagong.yunjiagong.model.ChangeModel;
import com.niule.yunjiagong.yunjiagong.util.MessageInfoV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haijun
 * @create 2018 - 08 - 10 - 17:49
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "addressInfo")
public class AddressInfoService {

    @Autowired
    private AddressInfoMapper addressInfoMapper;
    @Autowired
    private IsChangeDataMapper isChangeDataMapper;
    @Autowired
    private HotCityMapper hotCityMapper;

    @Cacheable(value = "commonApi:getAddressInfo", key = "#root.targetClass.getName()", unless = "#result eq null")
    public MessageInfoV1<AddressInfoModel> getAddressInfo() {
        log.info("准备获取地址信息");
        MessageInfoV1<AddressInfoModel> modelMessageInfoV1 = new MessageInfoV1<>();

        AddressInfoModel addressInfoModel = new AddressInfoModel();

        List<String> allCity = new ArrayList<>();
        List<String> hotCity = new ArrayList<>();
        Map<String, List<String>> stringListMap = new HashMap<>();
        List<AddressInfo> addressInfos = addressInfoMapper.selectAll();
        List<String> stringList = getStringList();
        for (int i = 0; i < stringList.size(); i++) {
            List<String> cityV1 = new ArrayList<>();
            for (int j = 0; j < addressInfos.size(); j++) {
                if (stringList.get(i).equals(addressInfos.get(j).getCode())) {
                    cityV1.add(addressInfos.get(j).getName());
                }
            }
            stringListMap.put(stringList.get(i), cityV1);
        }
        List<HotCity> hotCities = hotCityMapper.selectAll();
        for (int i = 0; i < hotCities.size(); i++) {
            hotCity.add(hotCities.get(i).getName());
        }
        for (int i = 0; i < addressInfos.size(); i++) {
            allCity.add(addressInfos.get(i).getName());
        }
        addressInfoModel.setAllCity(allCity);
        addressInfoModel.setHotCity(hotCity);
        addressInfoModel.setKeyCity(stringListMap);

        //修改状态
//        isChangeDataMapper.updateChangeData("address_info");

        modelMessageInfoV1.setData(addressInfoModel);
        modelMessageInfoV1.setContent("success");
        log.info("获取地址信息完成");
        return modelMessageInfoV1;
    }

    public ChangeModel getIsChange() {
        ChangeModel changeModel = new ChangeModel();
        IsChangeData isChangeData = new IsChangeData();
        isChangeData.setName("address_info");
        IsChangeData isChangeDataInfo = isChangeDataMapper.selectOne(isChangeData);
        changeModel.setVersion(isChangeDataInfo.getValue());
        return changeModel;
    }

    public List<String> getStringList() {
        List<String> stringList = new ArrayList<>();
        List<Character> characterList = new ArrayList<>();
        for (int i = 65; i < 91; i++) {
            characterList.add((char) i);
        }
        for (int i = 0; i < characterList.size(); i++) {
            stringList.add(characterList.get(i).toString());
        }
        return stringList;
    }
}
