package com.koalaIT.common.mapper;

import com.koalaIT.common.model.Huntercollect;
import com.koalaIT.common.model.HuntercollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HuntercollectMapper {
    int countByExample(HuntercollectExample example);

    int deleteByExample(HuntercollectExample example);

    int deleteByPrimaryKey(Integer collectId);

    int insert(Huntercollect record);

    int insertSelective(Huntercollect record);

    List<Huntercollect> selectByExample(HuntercollectExample example);

    Huntercollect selectByPrimaryKey(Integer collectId);

    int updateByExampleSelective(@Param("record") Huntercollect record, @Param("example") HuntercollectExample example);

    int updateByExample(@Param("record") Huntercollect record, @Param("example") HuntercollectExample example);

    int updateByPrimaryKeySelective(Huntercollect record);

    int updateByPrimaryKey(Huntercollect record);
}