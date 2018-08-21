package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.AddressInfoMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.AddressInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 08 - 14 - 9:48
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class AddressInfoMapperTest {

    @Autowired
    private AddressInfoMapper addressInfoMapper;

    @Test
    public void getAddressInfo() {
        List<AddressInfo> addressInfos = addressInfoMapper.selectAll();
        System.out.println(addressInfos.size());
    }
}
