package com.niule.marketing.controller.controller.dal.mapper.define;

import com.niule.marketing.controller.controller.dal.model.define.ReceiptApplyResponse;
import com.niule.marketing.controller.controller.model.ReceiptApplyRequestModel;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 18 - 17:57
 */
public interface ReceiptApplyResponseMapper {

    List<ReceiptApplyResponse> searchReceiptInfo(ReceiptApplyRequestModel receiptApplyRequestModel);
}
