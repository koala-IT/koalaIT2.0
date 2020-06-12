package com.koalaIT.common.mapper;

import com.koalaIT.common.model.Boss;
import com.koalaIT.common.model.BossExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BossMapper {
    int countByExample(BossExample example);

    int deleteByExample(BossExample example);

    int deleteByPrimaryKey(Integer bossId);

    int insert(Boss record);

    int insertSelective(Boss record);

    List<Boss> selectByExample(BossExample example);

    Boss selectByPrimaryKey(Integer bossId);

    int updateByExampleSelective(@Param("record") Boss record, @Param("example") BossExample example);

    int updateByExample(@Param("record") Boss record, @Param("example") BossExample example);

    int updateByPrimaryKeySelective(Boss record);

    int updateByPrimaryKey(Boss record);
}