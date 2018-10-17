package com.niule.marketing.controller.controller.dal.mapper.define;

import com.niule.marketing.controller.controller.dal.model.define.FinanceCountResponse;
import com.niule.marketing.controller.controller.model.FinanceCountRequestModel;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 25 - 10:56
 */
public interface FinanceCountResponseMapper {

    List<FinanceCountResponse> searchFinanceCount(FinanceCountRequestModel financeCountRequestModel);
}
