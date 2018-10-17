package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.UserReceiptApply;
import com.niule.marketing.controller.controller.dal.model.UserReceiptApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserReceiptApplyMapper {
    int countByExample(UserReceiptApplyExample example);

    int deleteByExample(UserReceiptApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserReceiptApply record);

    int insertSelective(UserReceiptApply record);

    List<UserReceiptApply> selectByExample(UserReceiptApplyExample example);

    UserReceiptApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserReceiptApply record, @Param("example") UserReceiptApplyExample example);

    int updateByExample(@Param("record") UserReceiptApply record, @Param("example") UserReceiptApplyExample example);

    int updateByPrimaryKeySelective(UserReceiptApply record);

    int updateByPrimaryKey(UserReceiptApply record);
}