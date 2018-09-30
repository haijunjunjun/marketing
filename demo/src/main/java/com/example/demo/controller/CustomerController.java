package com.example.demo.controller;

import com.example.demo.config.annotation.Operator;
import com.example.demo.dal.model.CustomerInfo;
import com.example.demo.model.*;
import com.example.demo.model.http.HttpCustGoldBeansDetail;
import com.example.demo.service.CustomerService;
import com.example.demo.util.MessageInfo;
import com.example.demo.util.MessageInfoV1;
import com.example.demo.util.MessageInfoV2;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.List;

@Slf4j
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 获取客户信息
     */
    @RequestMapping(value = "/marketing/customer/info", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<PageInfo<CustRespModel>>> getCustomerInfo(@Valid @NotNull @Operator CurOperator curOperator,
                                                                                @Valid @NotNull @RequestParam("status") Integer status,
                                                                                @Valid @NotNull @RequestParam("pageSize") Integer pageSize,
                                                                                @Valid @NotNull @RequestParam("pageNum") Integer pageNum) {
        return ResponseEntity.ok(customerService.getCustomerInfo(curOperator.getId(), status, pageNum, pageSize));
    }

    /**
     * 编辑客户信息
     */
    @RequestMapping(value = "/marketing/customer/edit", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> updateCustomerInfo(@Valid @RequestBody(required = true) CustomerInfo customerInfo) {
        return ResponseEntity.ok(customerService.editCustomerInfo(customerInfo));
    }

    /**
     * 放弃用户(放弃删除)
     */
    @RequestMapping(value = "/marketing/customer/remove", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> removeCustomerInfo(@Valid @RequestBody(required = true) Reason reason) {
        return ResponseEntity.ok(customerService.removeCustomerInfo(reason.getCustId(), reason.getStatus(), reason.getReason()));
    }

    /**
     * 赠送客户金豆
     */
    @RequestMapping(value = "/marketing/customer/donate/beans", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo> donateCustGoldBeans(@Valid @NotNull @Operator CurOperator curOperator,
                                                           @Valid @NotNull @RequestBody(required = true) DonateGoldBeansModel donateGoldBeansModel) throws Exception {
        return ResponseEntity.ok(customerService.donateGoldBeans(curOperator.getId(), donateGoldBeansModel.getCustId(), donateGoldBeansModel.getGoldBeansNum()));
    }

    /**
     * 获取赠送客户的金豆数量
     */
    @RequestMapping(value = "/marketing/customer/donate/beans/num", method = RequestMethod.GET)
    public ResponseEntity<MessageInfo<Integer>> getCustGoldBeans() {
        return ResponseEntity.ok(customerService.getCustGoldBeans());
    }

    /**
     * 客户信息报备
     */
    @RequestMapping(value = "/marketing/customer/save", method = RequestMethod.POST)
    public ResponseEntity<MessageInfoV2> saveCustomerInfo(@Valid @NotNull @Operator CurOperator curOperator,
                                                          @Valid @RequestBody(required = true) CustomerInfo customerInfo) {
        return ResponseEntity.ok(customerService.saveCustomerInfo(curOperator.getId(), customerInfo));
    }

    /**
     * 保存签约价格
     */
    @RequestMapping(value = "/marketing/customer/price", method = RequestMethod.POST)
    public ResponseEntity<MessageInfoV1> updateCustomerPrice(@Valid @NotNull @RequestBody(required = true) CustPriceModel custPriceModel) {
        return ResponseEntity.ok(customerService.updateCustomerPrice(custPriceModel.getId(), custPriceModel.getPrice()));
    }

    /**
     * 编辑信息时获取客户信息
     */
    @RequestMapping(value = "/marketing/cust/info", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<CustInfoModel>> getCustInfo(@Valid @NotNull @RequestParam("custId") Integer custId) {
        return ResponseEntity.ok(customerService.getCustInfo(custId));
    }

    /**
     * 客户发票申请
     */
    @RequestMapping(value = "/marketing/cust/receipt/apply", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<String>> custReceiptApply(@Valid @NotNull @Operator CurOperator curOperator,
                                                                @Valid @NotNull @RequestBody(required = true) UserCustReceiptApplyModel userCustReceiptApplyModel) {
        return ResponseEntity.ok(customerService.custReceiptApply(curOperator.getId(), userCustReceiptApplyModel));
    }

    /**
     * 获取客户详情基本信息
     */
    @RequestMapping(value = "/marketing/customer/detail/info", method = RequestMethod.POST)
    public ResponseEntity<CustBaseInfo> getCustomerDetailInfo(@Valid @NotNull @RequestBody(required = true) CustModel custModel) {
        return ResponseEntity.ok(customerService.getCustBaseInfo(custModel));
    }

    /**
     * 客户详情信息动作记录
     */
    @RequestMapping(value = "/marketing/customer/detail/info/action", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<String>> custBaseAction(@Valid @NotNull @Operator CurOperator curOperator,
                                                              @Valid @NotNull @RequestBody(required = true) CustBaseActionModel custBaseActionModel) throws ParseException {
        return ResponseEntity.ok(customerService.custBaseAction(curOperator.getId(), custBaseActionModel.getCustId(), custBaseActionModel.getActionCode(), custBaseActionModel.getOperateTime(), custBaseActionModel.getMark()));
    }

    /**
     * 客户详情操作记录
     */
    @RequestMapping(value = "/marketing/customer/detail/info/operate", method = RequestMethod.POST)
    public ResponseEntity<List<CustBaseOperateModel>> custBaseOperate(@Valid @NotNull @Operator CurOperator curOperator,
                                                                      @Valid @NotNull @RequestBody(required = true) CustModel custModel) {
        return ResponseEntity.ok(customerService.custBaseOperate(curOperator.getId(), custModel.getCustId()));
    }

    /**
     * 客户详情操作记录 编辑信息获取
     */
    @RequestMapping(value = "/marketing/customer/detail/operate/edit/info", method = RequestMethod.POST)
    public ResponseEntity<CustBaseOperateEditInfoModel> custBaseOperateEditInfo(@Valid @NotNull @RequestBody(required = true) IdModel idModel) {
        return ResponseEntity.ok(customerService.getCustBaseOperateEditInfo(idModel.getId()));
    }

    /**
     * 客户详情操作记录 编辑操作
     */
    @RequestMapping(value = "/marketing/customer/detail/operate/edit", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<String>> custBaseOperateEdit(@Valid @NotNull @RequestBody(required = true) CustBaseOperateEditInfoModel custBaseOperateEditInfoModel) throws ParseException {
        return ResponseEntity.ok(customerService.custBaseOperateEdit(custBaseOperateEditInfoModel));
    }

    /**
     * 客户详情操作记录 删除操作
     */
    @RequestMapping(value = "/marketing/customer/detail/operate/delete", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<String>> custBaseOperateDelete(@Valid @NotNull @RequestBody(required = true) IdModel idModel) throws ParseException {
        return ResponseEntity.ok(customerService.custBaseOperateDelete(idModel));
    }

    /**
     * 金豆明细
     */
    @RequestMapping(value = "/marketing/customer/gold/detail/info", method = RequestMethod.POST)
    public ResponseEntity<MessageInfo<List<HttpCustGoldBeansDetail>>> custGoldDetailInfo(@Valid @NotNull @RequestBody(required = true) CustModel custModel) throws Exception {
        return ResponseEntity.ok(customerService.getCustGoldBeansDetail(custModel.getCustId()));
    }
}
