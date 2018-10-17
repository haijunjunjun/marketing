package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.PayRecordFinal;
import com.niule.marketing.controller.controller.dal.model.PayRecordFinalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayRecordFinalMapper {
    int countByExample(PayRecordFinalExample example);

    int deleteByExample(PayRecordFinalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayRecordFinal record);

    int insertSelective(PayRecordFinal record);

    List<PayRecordFinal> selectByExample(PayRecordFinalExample example);

    PayRecordFinal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayRecordFinal record, @Param("example") PayRecordFinalExample example);

    int updateByExample(@Param("record") PayRecordFinal record, @Param("example") PayRecordFinalExample example);

    int updateByPrimaryKeySelective(PayRecordFinal record);

    int updateByPrimaryKey(PayRecordFinal record);
}