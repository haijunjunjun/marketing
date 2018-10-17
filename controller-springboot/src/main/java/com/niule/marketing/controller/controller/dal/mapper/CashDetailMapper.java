package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.CashDetail;
import com.niule.marketing.controller.controller.dal.model.CashDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CashDetailMapper {
    int countByExample(CashDetailExample example);

    int deleteByExample(CashDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CashDetail record);

    int insertSelective(CashDetail record);

    List<CashDetail> selectByExample(CashDetailExample example);

    CashDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CashDetail record, @Param("example") CashDetailExample example);

    int updateByExample(@Param("record") CashDetail record, @Param("example") CashDetailExample example);

    int updateByPrimaryKeySelective(CashDetail record);

    int updateByPrimaryKey(CashDetail record);
}