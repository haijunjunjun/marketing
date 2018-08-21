package com.niule.yunjiagong.yunjiagong.service;

import com.niule.yunjiagong.yunjiagong.dal.mapper.AddressInfoMapper;
import com.niule.yunjiagong.yunjiagong.dal.mapper.IsChangeDataMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.AddressInfo;
import com.niule.yunjiagong.yunjiagong.dal.model.IsChangeData;
import com.niule.yunjiagong.yunjiagong.model.AddressInfoModel;
import com.niule.yunjiagong.yunjiagong.util.BizRuntimeException;
import com.niule.yunjiagong.yunjiagong.util.MessageInfoV1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author haijun
 * @create 2018 - 08 - 10 - 17:49
 */
@Slf4j
@Service
public class AddressInfoService {

    @Autowired
    private AddressInfoMapper addressInfoMapper;
    @Autowired
    private IsChangeDataMapper isChangeDataMapper;

    public MessageInfoV1<AddressInfoModel> getAddressInfo() {
        MessageInfoV1<AddressInfoModel> modelMessageInfoV1 = new MessageInfoV1<>();
        IsChangeData isChangeData = new IsChangeData();
        isChangeData.setName("address_info");
        IsChangeData isChangeDataInfo = isChangeDataMapper.selectOne(isChangeData);
        if (Objects.isNull(isChangeDataInfo)) {
            log.info("数据库信息查询异常!");
            throw new BizRuntimeException("数据库查询异常！");
        }
        if ("0".equals(isChangeDataInfo.getValue())) {
            modelMessageInfoV1.setContent("noChange");
            return modelMessageInfoV1;
        }

        AddressInfoModel addressInfoModel = new AddressInfoModel();

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
        for (int i = 0; i < addressInfos.size(); i++) {
            hotCity.add(addressInfos.get(i).getName());
        }
        addressInfoModel.setHotCity(hotCity);
        addressInfoModel.setKeyCity(stringListMap);

        //修改状态
        IsChangeData isChangeDataV1 = new IsChangeData();
        isChangeDataV1.setId(isChangeDataInfo.getId());
        isChangeDataV1.setValue("0");
        isChangeDataV1.setModifyTime(new Date());
        isChangeDataMapper.updateByPrimaryKeySelective(isChangeDataV1);

        modelMessageInfoV1.setData(addressInfoModel);
        modelMessageInfoV1.setContent("success");
        return modelMessageInfoV1;
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
