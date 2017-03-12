package com.aisino.mapper;

import com.aisino.entity.Invoiceerror;
import com.aisino.entity.InvoiceerrorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvoiceerrorMapper {
    int countByExample(InvoiceerrorExample example);

    int deleteByExample(InvoiceerrorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Invoiceerror record);

    int insertSelective(Invoiceerror record);

    List<Invoiceerror> selectByExample(InvoiceerrorExample example);

    Invoiceerror selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Invoiceerror record, @Param("example") InvoiceerrorExample example);

    int updateByExample(@Param("record") Invoiceerror record, @Param("example") InvoiceerrorExample example);

    int updateByPrimaryKeySelective(Invoiceerror record);

    int updateByPrimaryKey(Invoiceerror record);
}