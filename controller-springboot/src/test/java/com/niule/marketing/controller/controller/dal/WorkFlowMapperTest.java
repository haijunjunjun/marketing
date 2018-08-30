package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.WorkFlowMapper;
import com.niule.marketing.controller.controller.dal.model.WorkFlow;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author haijun
 * @create 2018 - 08 - 29 - 16:35
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerApplication.class)
public class WorkFlowMapperTest {

    @Autowired
    private WorkFlowMapper workFlowMapper;

    @Test
    public void test (){
        WorkFlow workFlow = new WorkFlow();
        workFlow.setFlowId("1");
        workFlow.setFlowContent("test");
        workFlow.setFlowName("test");
        int insert = workFlowMapper.insert(workFlow);
        log.info("info is :"+insert);
    }
}
