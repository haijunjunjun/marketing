package com.example.demo.dal;

import com.example.demo.DemoApplication;
import com.example.demo.dal.mapper.AccountBankMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class AccountBankMapperTest {

    @Autowired
    private AccountBankMapper accountBankMapper;

    @Test
    public void updateBankInfoTest() {
        int i = accountBankMapper.updateBankInfo(1, "6217000340000351365", "海军", "建设银行");
        log.info("info is :" + i);
    }
}
