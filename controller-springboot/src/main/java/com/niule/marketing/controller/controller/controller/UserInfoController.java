package com.niule.marketing.controller.controller.controller;

import com.niule.marketing.controller.controller.config.CodeResponse;
import com.niule.marketing.controller.controller.config.DataResponse;
import com.niule.marketing.controller.controller.model.*;
import com.niule.marketing.controller.controller.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 09 - 11 - 16:37
 */
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Description("获取销售用户信息")
    @RequestMapping(value = "/background/market/user/info", method = RequestMethod.POST)
    public DataResponse getMarketUserInfo() {
        return DataResponse.success(userInfoService.getUserInfo());
    }

    @Description("查找销售用户信息")
    @RequestMapping(value = "/background/market/search/user/info", method = RequestMethod.POST)
    public DataResponse searchUserInfo(@Valid @NotNull @RequestBody(required = true) UserSearchRequestModel userSearchRequestModel) {
        return DataResponse.success(userInfoService.searchUserInfo(userSearchRequestModel));
    }

    @Description("增加销售用户信息")
    @RequestMapping(value = "/background/market/add/user/info", method = RequestMethod.POST)
    public DataResponse addUserInfo(@Valid @NotNull @RequestBody(required = true) UserAddRequestModel userAddRequestModel) {
        return DataResponse.success(userInfoService.addUserInfo(userAddRequestModel));
    }

    @Description("获取用户角色信息")
    @RequestMapping(value = "/market/user/role/info", method = RequestMethod.POST)
    public DataResponse getUserRoleInfo() {
        return DataResponse.success(userInfoService.getRoleInfo());
    }

    @Description("销售用户文件上传")
    @RequestMapping(value = "/market/file/upload", method = RequestMethod.POST)
    public DataResponse fileUpload(@Valid @NotNull @RequestBody(required = true) FileUploadRequestModel fileUploadRequestModel) {
        return DataResponse.success(userInfoService.fileUpload(fileUploadRequestModel));
    }

    @Description("增加销售用户信息时所需要添加的管理员信息")
    @RequestMapping(value = "/market/user/fetch/branch/manage/info", method = RequestMethod.POST)
    public DataResponse fetchBranchManageInfo() {
        return DataResponse.success(userInfoService.fetchBranchManageInfo());
    }

    @Description("销售人员删除")
    @RequestMapping(value = "/background/market/user/delete", method = RequestMethod.POST)
    public DataResponse deleteMarketUser(@Valid @NotNull @RequestBody(required = true) UserModel userModel) {
        return DataResponse.success(userInfoService.deleteMarketUser(userModel));
    }

    @Description("查看销售人员详情信息")
    @RequestMapping(value = "/market/user/view/detail/info", method = RequestMethod.POST)
    public DataResponse viewUserDetailInfo(@Valid @NotNull @RequestBody(required = true) UserModel userModel) {
        return DataResponse.success(userInfoService.getUserDetailInfo(userModel.getUserId()));
    }

    @Description("查看销售人员的动作记录信息")
    @RequestMapping(value = "/market/user/view/action/info", method = RequestMethod.POST)
    public DataResponse viewUserActionInfo(@Valid @NotNull @RequestBody(required = true) UserModel userModel) {
        return DataResponse.success(userInfoService.viewUserActionInfo(userModel.getUserId()));
    }

    @Description("查询获取当前操作人员的动作记录信息")
    @RequestMapping(value = "/market/user/search/action/info", method = RequestMethod.POST)
    public DataResponse searchUserActionInfo(@Valid @NotNull @RequestBody(required = true) UserActionRequestModel userActionRequestModel) {
        if (!Objects.isNull(userActionRequestModel.getUserId())) {
            return DataResponse.success(userInfoService.searchUserActionInfo(userActionRequestModel));
        }
        return DataResponse.error(new CodeResponse(400010, "userId 不能为空!"));
    }

    @Description("查询销售人员的业绩统计信息")
    @RequestMapping(value = "/market/user/search/performance/info", method = RequestMethod.POST)
    public DataResponse searchUserPerformanceInfo(@Valid @NotNull @RequestBody(required = true) DateRequestModel dateRequestModel) {
        if (!Objects.isNull(dateRequestModel.getUserId())) {
            return DataResponse.success(userInfoService.searchUserPerformanceInfo(dateRequestModel));
        }
        return DataResponse.error(new CodeResponse(400010, "userId 不能为空!"));
    }

    @Description("金豆明细")
    @RequestMapping(value = "/market/user/gold/detail/info", method = RequestMethod.POST)
    public DataResponse getUserGoldBeanDetail(@Valid @NotNull @RequestBody(required = true) UserModel userModel) {
        if (!Objects.isNull(userModel.getUserId())) {
            return DataResponse.success(userInfoService.getUserGoldDetailInfo(userModel));
        }
        return DataResponse.error(new CodeResponse(400010, "userId 不能为空!"));
    }

    @Description("查看销售人员的小组成员")
    @RequestMapping(value = "/market/user/team/info", method = RequestMethod.POST)
    public DataResponse getUserTeamInfo(@Valid @NotNull @RequestBody(required = true) UserModel userModel) {
        if (!Objects.isNull(userModel.getUserId())) {
            return DataResponse.success(userInfoService.getUserTeamInfo(userModel));
        }
        return DataResponse.error(new CodeResponse(400010, "userId 不能为空!"));
    }

    @Description("销售人员金豆审核")
    @RequestMapping(value = "/market/user/gold/apply/info", method = RequestMethod.POST)
    public DataResponse getUserGoldApplyInfo(@Valid @NotNull @RequestBody(required = true) UserModel userModel) {
        if (!Objects.isNull(userModel.getUserId())) {
            return DataResponse.success(userInfoService.getUserGoldBeansApplyInfo(userModel));
        }
        return DataResponse.error(new CodeResponse(400010, "userId 不能为空!"));
    }

    @Description("查看销售人员财务信息")
    @RequestMapping(value = "/market/user/finance/detail/info", method = RequestMethod.POST)
    public DataResponse getUserFinanceInfo(@Valid @NotNull @RequestBody(required = true) IdModel idModel) {
        if (!Objects.isNull(idModel.getId())) {
            return DataResponse.success(userInfoService.getMarketUserFinanceDeailInfo(idModel));
        }
        return DataResponse.error(new CodeResponse(400010, "userId 不能为空!"));
    }

    @Description("安排与总结")
    @RequestMapping(value = "/market/user/arange/sum/info", method = RequestMethod.POST)
    public DataResponse getUserSumArange(@Valid @NotNull @RequestBody(required = true) UserModel userModel) {
        if (!Objects.isNull(userModel.getUserId())) {
            return DataResponse.success(userInfoService.getUserSumArange(userModel));
        }
        return DataResponse.error(new CodeResponse(400010, "userId 不能为空!"));
    }

    @Description("销售人员信息编辑")
    @RequestMapping(value = "/background/market/user/info/edit", method = RequestMethod.POST)
    public DataResponse editUserInfo(@Valid @NotNull @RequestBody(required = true) UserEditRequestModel userEditRequestModel) {
        if (!Objects.isNull(userEditRequestModel.getUserId())) {
            return DataResponse.success(userInfoService.editUserInfo(userEditRequestModel));
        }
        return DataResponse.error(new CodeResponse(400010, "userId 不能为空!"));
    }

    @Description("合同审核列表")
    @RequestMapping(value = "/market/user/cust/compact/check", method = RequestMethod.POST)
    public DataResponse searchUserToCustCompactCheckInfo(@Valid @NotNull @RequestBody(required = true) CompactCheckRequestModel compactCheckRequestModel) {
        return DataResponse.success(userInfoService.searchUserToCustCompactCheckInfo(compactCheckRequestModel));
    }

    @Description("发票申请列表")
    @RequestMapping(value = "/market/user/receipt/apply/info", method = RequestMethod.POST)
    public DataResponse getUserReceiptApplyInfo(@Valid @NotNull @RequestBody(required = true) ReceiptApplyRequestModel receiptApplyRequestModel) {
        return DataResponse.success(userInfoService.getUserReceiptApplyInfo(receiptApplyRequestModel));
    }

    @Description("合同审核列表编辑信息获取")
    @RequestMapping(value = "/market/cust/compact/check/edit/info", method = RequestMethod.POST)
    public DataResponse getEditCustCompactInfo(@Valid @NotNull @RequestBody(required = true) CustModel custModel) {
        return DataResponse.success(userInfoService.editCustCompactInfo(custModel.getCustId()));
    }

    @Description("合同审核列表编辑")
    @RequestMapping(value = "/market/cust/compact/check/edit", method = RequestMethod.POST)
    public DataResponse editCustCompactInfo(@Valid @NotNull @RequestBody(required = true) CompactCheckEditInfoRequestModel compactCheckEditInfoRequestModel) {
        return DataResponse.success(userInfoService.editCustCompactInfo(compactCheckEditInfoRequestModel));
    }

    @Description("发票申请列表编辑信息获取")
    @RequestMapping(value = "/market/user/receipt/apply/edit/info", method = RequestMethod.POST)
    public DataResponse getEditReceiptInfo(@Valid @NotNull @RequestBody(required = true) IdModel idModel) {
        return DataResponse.success(userInfoService.getEditUserReceiptApplyInfo(idModel));
    }

    @Description("发票申请列表编辑")
    @RequestMapping(value = "/market/user/receipt/apply/edit", method = RequestMethod.POST)
    public DataResponse editReceiptInfo(@Valid @NotNull @RequestBody(required = true) ReceiptCheckEditInfoRequestModel receiptCheckEditInfoRequestModel) {
        return DataResponse.success(userInfoService.editReceiptInfo(receiptCheckEditInfoRequestModel));
    }
}
