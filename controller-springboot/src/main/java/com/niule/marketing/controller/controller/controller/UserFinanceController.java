package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.model.*;
import com.niule.marketing.controller.controller.service.UserFinanceService;
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
 * @create 2018 - 09 - 19 - 10:30
 */
@RestController
public class UserFinanceController {

    @Autowired
    private UserFinanceService userFinanceService;

    @Description("提现申请")
    @RequestMapping(value = "/market/user/cash/detail/info", method = RequestMethod.POST)
    public DataResponse getUserCashDetailInfo(@Valid @NotNull @RequestBody(required = true) UserCashDetailRequestModel cashDetailRequestModel) {
        return DataResponse.success(userFinanceService.getUserCashDetailInfo(cashDetailRequestModel));
    }

//    @Description("提成结算")
//    @RequestMapping(value = "/market/user/commission/detail/info", method = RequestMethod.POST)
//    public DataResponse getUserCommissionInfo(@Valid @NotNull @RequestBody(required = true) UserCommissionRequestModel userCommissionRequestModel) {
//        return DataResponse.success(userFinanceService.getUserCommissionInfo(userCommissionRequestModel));
//    }

    @Description("提现操作审核")
    @RequestMapping(value = "/market/user/cash/check", method = RequestMethod.POST)
    public DataResponse userCashCheck(@Valid @NotNull @RequestBody(required = true) UserCashCheckRequestModel userCashCheckRequestModel) {
        return DataResponse.success(userFinanceService.userCashCheck(userCashCheckRequestModel));
    }

    @Description("提现操作审核编辑信息")
    @RequestMapping(value = "/market/user/cash/check/edit/info", method = RequestMethod.POST)
    public DataResponse userCashCheckEditInfo(@Valid @NotNull @RequestBody(required = true) IdModel idModel) {
        return DataResponse.success(userFinanceService.userCashCheckEditInfo(idModel));
    }

    @Description("打款操作审核")
    @RequestMapping(value = "/market/user/money/check", method = RequestMethod.POST)
    public DataResponse userMoneyCheck(@Valid @NotNull @RequestBody(required = true) UserMoneyCheckRequestModel userMoneyCheckRequestModel) {
        return DataResponse.success(userFinanceService.userMoneyCheck(userMoneyCheckRequestModel));
    }

    @Description("财务统计")
    @RequestMapping(value = "/market/user/finance/count", method = RequestMethod.POST)
    public DataResponse getFinanceCount(@Valid @NotNull @RequestBody(required = true) FinanceCountRequestModel financeCountRequestModel) {
        return DataResponse.success(userFinanceService.searchFinanceCount(financeCountRequestModel));
    }

    @Description("提成计算添加操作")
    @RequestMapping(value = "/market/user/commission/total/add", method = RequestMethod.POST)
    public DataResponse userCommissionCountAdd(@Valid @NotNull @RequestBody(required = true) MarketUserCommissionEditModel marketUserCommissionEditModel) {
        return DataResponse.success(userFinanceService.userCommissionCountAdd(marketUserCommissionEditModel));
    }

    @Description("提成计算编辑操作")
    @RequestMapping(value = "/market/user/commission/total/edit", method = RequestMethod.POST)
    public DataResponse userCommissionCountEdit(@Valid @NotNull @RequestBody(required = true) MarketUserCommissionEditModel marketUserCommissionEditModel) {
        return DataResponse.success(userFinanceService.userCommissionCountEdit(marketUserCommissionEditModel));
    }

    @Description("提成计算编辑操作信息获取")
    @RequestMapping(value = "/market/user/commission/total/edit/info", method = RequestMethod.POST)
    public DataResponse userCommissionCountEditInfo(@Valid @NotNull @RequestBody(required = true) IdModel idModel) {
        return DataResponse.success(userFinanceService.getMarketUserCommissionEditInfo(idModel));
    }

    @Description("提成计算信息展示")
    @RequestMapping(value = "/market/user/commission/total/view", method = RequestMethod.POST)
    public DataResponse userCommissionCountView(@Valid @NotNull @RequestBody(required = true) MarketUserCommissionRequestModel marketUserCommissionRequestModel) {
        return DataResponse.success(userFinanceService.userCommissionCountResponse(marketUserCommissionRequestModel));
    }

    @Description("提成添加编辑 获取城市信息")
    @RequestMapping(value = "/market/user/commission/city/info", method = RequestMethod.POST)
    public DataResponse userCommissionCityInfo() {
        return DataResponse.success(userFinanceService.getAreaCityInfo());
    }

    @Description("提成添加编辑 通过城市信息获取名字")
    @RequestMapping(value = "/market/user/commission/name/info", method = RequestMethod.POST)
    public DataResponse userCommissionNameInfo(@Valid @NotNull @RequestBody(required = true) CityModel cityModel) {
        return DataResponse.success(userFinanceService.fetchUserRealName(cityModel.getCity()));
    }

    @Description("提成添加编辑 获取奖金")
    @RequestMapping(value = "/market/user/commission/info", method = RequestMethod.POST)
    public DataResponse userCommissionInfo(@Valid @NotNull @RequestBody(required = true) CommissionModel commissionModel) {
        return DataResponse.success(userFinanceService.fetchUserCommission(commissionModel));
    }
}
