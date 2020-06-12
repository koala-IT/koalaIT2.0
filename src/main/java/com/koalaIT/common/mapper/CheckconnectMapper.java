package com.koalaIT.common.mapper;

import com.koalaIT.common.model.Checkconnect;
import com.koalaIT.common.model.CheckconnectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckconnectMapper {
    int countByExample(CheckconnectExample example);

    int deleteByExample(CheckconnectExample example);

    int deleteByPrimaryKey(Integer check);

    int insert(Checkconnect record);

    int insertSelective(Checkconnect record);

    List<Checkconnect> selectByExample(CheckconnectExample example);

    Checkconnect selectByPrimaryKey(Integer check);

    int updateByExampleSelective(@Param("record") Checkconnect record, @Param("example") CheckconnectExample example);

    int updateByExample(@Param("record") Checkconnect record, @Param("example") CheckconnectExample example);

    int updateByPrimaryKeySelective(Checkconnect record);

    int updateByPrimaryKey(Checkconnect record);
}