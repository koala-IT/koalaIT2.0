package com.koalaIT.common.mapper;

import com.koalaIT.common.model.Hunter;
import com.koalaIT.common.model.HunterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HunterMapper {
    int countByExample(HunterExample example);

    int deleteByExample(HunterExample example);

    int deleteByPrimaryKey(Integer hunterId);

    int insert(Hunter record);

    int insertSelective(Hunter record);

    List<Hunter> selectByExample(HunterExample example);

    Hunter selectByPrimaryKey(Integer hunterId);

    int updateByExampleSelective(@Param("record") Hunter record, @Param("example") HunterExample example);

    int updateByExample(@Param("record") Hunter record, @Param("example") HunterExample example);

    int updateByPrimaryKeySelective(Hunter record);

    int updateByPrimaryKey(Hunter record);
}