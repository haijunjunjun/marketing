package com.niule.marketing.controller.controller.dal.mapper;

import com.niule.marketing.controller.controller.dal.model.SalesTech;
import com.niule.marketing.controller.controller.dal.model.SalesTechExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesTechMapper {
    int countByExample(SalesTechExample example);

    int deleteByExample(SalesTechExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SalesTech record);

    int insertSelective(SalesTech record);

    List<SalesTech> selectByExample(SalesTechExample example);

    SalesTech selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SalesTech record, @Param("example") SalesTechExample example);

    int updateByExample(@Param("record") SalesTech record, @Param("example") SalesTechExample example);

    int updateByPrimaryKeySelective(SalesTech record);

    int updateByPrimaryKey(SalesTech record);
}