package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.define.CustomerResponseMapper;
import com.niule.marketing.controller.controller.dal.model.define.CustomerResponse;
import com.niule.marketing.controller.controller.model.CustomerSearchRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 14:58
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerApplication.class)
public class CustomerResponseMapperTest {

    @Autowired
    private CustomerResponseMapper customerResponseMapper;

    @Test
    public void t1 (){
        CustomerSearchRequestModel customerSearchRequestModel = new CustomerSearchRequestModel();
        customerSearchRequestModel.setUserRealName("海军");
        List<CustomerResponse> customerResponses = customerResponseMapper.searchCustInfo(customerSearchRequestModel);
        log.info("customerResponse is :"+customerResponses.size());
    }
}
