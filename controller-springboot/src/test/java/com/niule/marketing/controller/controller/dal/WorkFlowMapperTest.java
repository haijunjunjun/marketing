package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.WorkFlowMapper;
import com.niule.marketing.controller.controller.dal.model.WorkFlow;
import com.niule.marketing.controller.controller.dal.model.WorkFlowExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
        workFlow.setFlowId("2");
        workFlow.setFlowContent("testV2");
        workFlow.setFlowName("testV2");
        int insert = workFlowMapper.insert(workFlow);
        log.info("info is :"+insert);
    }

    @Test
    public void test1 (){
        WorkFlowExample workFlowExample = new WorkFlowExample();
        WorkFlowExample.Criteria criteria = workFlowExample.createCriteria();
        criteria.andFlowIdEqualTo("2");
        List<WorkFlow> workFlows = workFlowMapper.selectByExample(workFlowExample);
        log.info("info is :"+workFlows.get(0).getFlowContent());
    }

    @Test
    public void t2 (){

    }
}
