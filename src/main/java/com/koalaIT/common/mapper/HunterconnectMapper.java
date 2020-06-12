package com.koalaIT.common.mapper;

import com.koalaIT.common.model.Hunterconnect;
import com.koalaIT.common.model.HunterconnectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HunterconnectMapper {
    int countByExample(HunterconnectExample example);

    int deleteByExample(HunterconnectExample example);

    int deleteByPrimaryKey(Integer number);

    int insert(Hunterconnect record);

    int insertSelective(Hunterconnect record);

    List<Hunterconnect> selectByExample(HunterconnectExample example);

    Hunterconnect selectByPrimaryKey(Integer number);

    int updateByExampleSelective(@Param("record") Hunterconnect record, @Param("example") HunterconnectExample example);

    int updateByExample(@Param("record") Hunterconnect record, @Param("example") HunterconnectExample example);

    int updateByPrimaryKeySelective(Hunterconnect record);

    int updateByPrimaryKey(Hunterconnect record);
}