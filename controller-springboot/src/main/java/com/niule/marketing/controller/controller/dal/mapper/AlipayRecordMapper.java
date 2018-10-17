package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.AlipayRecord;
import com.niule.marketing.controller.controller.dal.model.AlipayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlipayRecordMapper {
    int countByExample(AlipayRecordExample example);

    int deleteByExample(AlipayRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AlipayRecord record);

    int insertSelective(AlipayRecord record);

    List<AlipayRecord> selectByExample(AlipayRecordExample example);

    AlipayRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AlipayRecord record, @Param("example") AlipayRecordExample example);

    int updateByExample(@Param("record") AlipayRecord record, @Param("example") AlipayRecordExample example);

    int updateByPrimaryKeySelective(AlipayRecord record);

    int updateByPrimaryKey(AlipayRecord record);
}