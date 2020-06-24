package com.koalaIT.common.mapper;

import com.koalaIT.common.model.Bosscollect;
import com.koalaIT.common.model.BosscollectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BosscollectMapper {
    int countByExample(BosscollectExample example);

    int deleteByExample(BosscollectExample example);

    int deleteByPrimaryKey(Integer collectId);

    int insert(Bosscollect record);

    int insertSelective(Bosscollect record);

    List<Bosscollect> selectByExample(BosscollectExample example);

    Bosscollect selectByPrimaryKey(Integer collectId);

    int updateByExampleSelective(@Param("record") Bosscollect record, @Param("example") BosscollectExample example);

    int updateByExample(@Param("record") Bosscollect record, @Param("example") BosscollectExample example);

    int updateByPrimaryKeySelective(Bosscollect record);

    int updateByPrimaryKey(Bosscollect record);
}