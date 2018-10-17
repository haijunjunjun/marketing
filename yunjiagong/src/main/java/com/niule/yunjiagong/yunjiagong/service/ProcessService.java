package com.niule.yunjiagong.yunjiagong.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.niule.yunjiagong.yunjiagong.dal.mapper.ProcessBreakConfigMapper;
import com.niule.yunjiagong.yunjiagong.dal.model.ProcessBreakConfig;
import com.niule.yunjiagong.yunjiagong.model.ProcessBreakRequestModel;
import com.niule.yunjiagong.yunjiagong.model.ProcessBreakResponseModel;
import com.niule.yunjiagong.yunjiagong.model.ReasonTypeModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author haijun
 * @create 2018 - 10 - 08 - 17:13
 */
@Service
public class ProcessService {

    @Autowired
    private ProcessBreakConfigMapper processBreakConfigMapper;

    public ProcessBreakResponseModel getProcessBreakConfig(ProcessBreakRequestModel processBreakRequestModel) {
        ProcessBreakResponseModel processBreakResponseModel = new ProcessBreakResponseModel();

        ProcessBreakConfig processBreakConfig = new ProcessBreakConfig();
        if (!StringUtils.isEmpty(processBreakRequestModel.getProcessType()) && processBreakRequestModel.getProcessType().length() != 0) {
            processBreakConfig.setProcessType(processBreakRequestModel.getProcessType());
        }
        if (!StringUtils.isEmpty(processBreakRequestModel.getReasonType()) && processBreakRequestModel.getReasonType().length() != 0) {
            processBreakConfig.setReasonType(processBreakRequestModel.getReasonType());
        }
        ProcessBreakConfig processBreakConfigInfo = processBreakConfigMapper.selectOne(processBreakConfig);
        if (!Objects.isNull(processBreakConfigInfo)) {
            String breakReasonMy = processBreakConfigInfo.getBreakReasonMy();
            String breakReasonOpppsitive = processBreakConfigInfo.getBreakReasonOpppsitive();
            List<ReasonTypeModel> splitInfo = this.getSplitInfo(breakReasonMy, breakReasonOpppsitive,processBreakRequestModel.getReasonType());
            JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(splitInfo));
            processBreakResponseModel.setBreakReason(jsonArray);
        }
        return processBreakResponseModel;
    }

    private List<ReasonTypeModel> getSplitInfo(String myReason, String oppositiveReason,String type) {
        List<ReasonTypeModel> reasonTypeModelList = new ArrayList<>();

        if (!StringUtils.isEmpty(myReason) && myReason.length() != 0) {
            String[] splitMyReason = myReason.split(",");
            for (int i = 0; i < splitMyReason.length; i++) {
                ReasonTypeModel reasonTypeModel = new ReasonTypeModel();
                reasonTypeModel.setReason(splitMyReason[i].trim());
                if ("1".equals(type)){
                    reasonTypeModel.setType("1");
                }else if ("2".equals(type)){
                    reasonTypeModel.setType("2");
                }
                reasonTypeModelList.add(reasonTypeModel);
            }
        }
        if (!StringUtils.isEmpty(oppositiveReason) && oppositiveReason.length() != 0) {
            String[] splitOppositiveReason = oppositiveReason.split(",");
            for (int i = 0; i < splitOppositiveReason.length; i++) {
                ReasonTypeModel reasonTypeModel = new ReasonTypeModel();
                reasonTypeModel.setReason(splitOppositiveReason[i].trim());
                if ("2".equals(type)){
                    reasonTypeModel.setType("1");
                }else if ("1".equals(type)){
                    reasonTypeModel.setType("2");
                }
                reasonTypeModelList.add(reasonTypeModel);
            }
        }

        return reasonTypeModelList;
    }
}
