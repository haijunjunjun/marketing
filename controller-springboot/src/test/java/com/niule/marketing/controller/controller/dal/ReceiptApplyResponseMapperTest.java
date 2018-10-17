package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.define.ReceiptApplyResponseMapper;
import com.niule.marketing.controller.controller.dal.model.define.ReceiptApplyResponse;
import com.niule.marketing.controller.controller.model.ReceiptApplyRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 19 - 9:48
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerApplication.class)
public class ReceiptApplyResponseMapperTest {

    @Autowired
    private ReceiptApplyResponseMapper receiptApplyResponseMapper;

    @Test
    public void t1() {
        ReceiptApplyRequestModel receiptApplyRequestModel = new ReceiptApplyRequestModel();
        List<ReceiptApplyResponse> receiptApplyResponses = receiptApplyResponseMapper.searchReceiptInfo(receiptApplyRequestModel);
        log.info("receiptApplyResponses is :" + receiptApplyResponses.size());
    }
}
