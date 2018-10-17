package com.niule.marketing.controller.controller.dal.mapper.define;

import com.niule.marketing.controller.controller.dal.model.define.CompactCheckResponse;
import com.niule.marketing.controller.controller.model.CompactCheckRequestModel;

import java.util.List;

/**
 * @author haijun
 * @create 2018 - 09 - 18 - 16:10
 */
public interface CompactCheckResponseMapper {

    List<CompactCheckResponse> searchCompactCheckInfo(CompactCheckRequestModel compactCheckRequestModel);
}
