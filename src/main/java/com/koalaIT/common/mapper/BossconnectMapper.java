package com.koalaIT.common.mapper;

import com.koalaIT.common.model.Bossconnect;
import com.koalaIT.common.model.BossconnectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BossconnectMapper {
    int countByExample(BossconnectExample example);

    int deleteByExample(BossconnectExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Bossconnect record);

    int insertSelective(Bossconnect record);

    List<Bossconnect> selectByExample(BossconnectExample example);

    Bossconnect selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Bossconnect record, @Param("example") BossconnectExample example);

    int updateByExample(@Param("record") Bossconnect record, @Param("example") BossconnectExample example);

    int updateByPrimaryKeySelective(Bossconnect record);

    int updateByPrimaryKey(Bossconnect record);
}