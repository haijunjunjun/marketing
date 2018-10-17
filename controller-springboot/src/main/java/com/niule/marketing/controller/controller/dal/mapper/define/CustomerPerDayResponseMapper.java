package com.niule.marketing.controller.controller.dal.mapper.define;

import com.niule.marketing.controller.controller.dal.model.define.CustomerPerDayResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 10 - 11 - 16:34
 */
public interface CustomerPerDayResponseMapper {

    List<CustomerPerDayResponse> getPerDayCustomerInfo (@Param("startTime") String startTime,@Param("endTime") String endTime);
}
