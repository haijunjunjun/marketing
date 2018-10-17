package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.model.CustModel;
import com.niule.marketing.controller.controller.model.CustomerSearchRequestModel;
import com.niule.marketing.controller.controller.service.CustomerInfoService;
import com.niule.marketing.controller.controller.service.httpService.HttpRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author haijun
 * @create 2018 - 09 - 10 - 16:55
 */
@Slf4j
@RestController
public class CustomerInfoController {

    @Autowired
    private CustomerInfoService customerInfoService;
    @Autowired
    private HttpRemoteService httpRemoteService;

    @Description("后台管理人员获取客户信息")
    @RequestMapping(value = "/background/fetch/cust/info", method = RequestMethod.GET)
    public DataResponse getCustomerInfo() {
        return DataResponse.success(customerInfoService.getCustomerInfo());
    }

    @Description("后台管理人员获取客户详细信息")
    @RequestMapping(value = "/background/fetch/cust/detail/info", method = RequestMethod.POST)
    public DataResponse getCustomerDetailInfo(@Valid @NotNull @RequestBody(required = true) CustModel custModel) {
        return DataResponse.success(customerInfoService.getCustomerDetailInfo(custModel.getCustId()));
    }

    @Description("获取销售人员对客户信息的变更工作记录信息")
    @RequestMapping(value = "/background/fetch/cust/action/info", method = RequestMethod.POST)
    public DataResponse getCustFollowRecordInfo(@Valid @NotNull @RequestBody(required = true) CustModel custModel) {
        return DataResponse.success(customerInfoService.getCustFollowRecordInfo(custModel.getCustId(), custModel.getPageNum(), custModel.getPageSize()));
    }

    @Description("获取客户的合同信息")
    @RequestMapping(value = "/background/fetch/cust/compact/info", method = RequestMethod.POST)
    public DataResponse getCustCompactInfo(@Valid @NotNull @RequestBody(required = true) CustModel custModel) {
        return DataResponse.success(customerInfoService.getCustCompactModel(custModel.getCustId(), custModel.getPageNum(), custModel.getPageSize()));
    }

    @Description("获取用户金豆详情")
    @RequestMapping(value = "/background/fetch/cust/gold/info", method = RequestMethod.POST)
    public DataResponse getCustGoldBeansInfo(@Valid @NotNull @RequestBody(required = true) CustModel custModel) throws Exception {
        log.info("开始获取信息");
        return DataResponse.success(httpRemoteService.getUserGoldBeansDetail(custModel.getPhone(), custModel.getPageNum(), custModel.getPageSize()));
    }

    @Description("获取客户的付款信息")
    @RequestMapping(value = "/background/fetch/cust/finance/info", method = RequestMethod.POST)
    public DataResponse getFinanceDetailInfo(@Valid @NotNull @RequestBody(required = true) CustModel custModel) {
        return DataResponse.success(customerInfoService.getFinanceDetailInfo(custModel.getCustId(), custModel.getPageNum(), custModel.getPageSize()));
    }

    @Description("后台管理人员查询客户信息")
    @RequestMapping(value = "/background/search/cust/info", method = RequestMethod.POST)
    public DataResponse searchCustInfo(@Valid @NotNull @RequestBody(required = true) CustomerSearchRequestModel customerSearchRequestModel) {
        return DataResponse.success(customerInfoService.searchCustomerInfo(customerSearchRequestModel));
    }

    @Description("后台管理人员删除客户信息")
    @RequestMapping(value = "/background/delete/cust/info", method = RequestMethod.POST)
    public DataResponse deleteCustInfo(@Valid @NotNull @RequestBody(required = true) CustModel custModel) {
        return DataResponse.success(customerInfoService.deleteCustInfo(custModel.getCustId()));
    }
}
