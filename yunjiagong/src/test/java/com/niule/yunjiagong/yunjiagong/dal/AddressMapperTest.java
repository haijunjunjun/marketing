package com.niule.yunjiagong.yunjiagong.dal;

import com.niule.yunjiagong.yunjiagong.YunjiagongApplication;
import com.niule.yunjiagong.yunjiagong.dal.mapper.AddressMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 07 - 24 - 17:39
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = YunjiagongApplication.class)
public class AddressMapperTest {

    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void getAddressListTest() {
        List<Address> addressList = addressMapper.getAddressList(1, 1);
        log.info("info's size is :" + addressList.size());
    }
}
