package com.niule.marketing.controller.controller.dal.mapper.define;

import com.niule.marketing.controller.controller.dal.model.define.CustomerResponse;
import com.niule.marketing.controller.controller.model.CustomerSearchRequestModel;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 12 - 14:19
 */
public interface CustomerResponseMapper {

    List<CustomerResponse> searchCustInfo(CustomerSearchRequestModel customerSearchRequestModel);
}
