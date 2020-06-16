package com.koalaIT.common.mapper;

import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Bossconnect;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BossconnectMapper <T extends BaseDO, E extends BaseExample> extends BaseMapper<T,E>{
    List<Bossconnect> findBossByID(Integer userId);

    List<Bossconnect> addCheck(Bossconnect bossconnect);

    Integer delBossConnect(Bossconnect bossconnect);

}