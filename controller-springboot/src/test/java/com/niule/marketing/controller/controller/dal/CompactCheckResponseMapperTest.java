package com.niule.marketing.controller.controller.dal;

import com.niule.marketing.controller.controller.ControllerApplication;
import com.niule.marketing.controller.controller.dal.mapper.define.CompactCheckResponseMapper;
import com.niule.marketing.controller.controller.dal.model.define.CompactCheckResponse;
import com.niule.marketing.controller.controller.model.CompactCheckRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 18 - 16:46
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ControllerApplication.class)
public class CompactCheckResponseMapperTest {

    @Autowired
    private CompactCheckResponseMapper compactCheckResponseMapper;

    @Test
    public void t1() {
        CompactCheckRequestModel compactCheckRequestModel = new CompactCheckRequestModel();
        compactCheckRequestModel.setCustName("葛先生");
        List<CompactCheckResponse> compactCheckResponses = compactCheckResponseMapper.searchCompactCheckInfo(compactCheckRequestModel);
        log.info("compactCheckResponses is :" + compactCheckResponses.size());
    }
}
