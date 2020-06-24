package com.koalaIT.common.mapper;

import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Boss;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BossMapper <T extends BaseDO, E extends BaseExample> extends BaseMapper<T,E>{
    List<Boss> searchBossInfo(String bossTitle);

    List<Boss> getBossByUser(Integer userId);

    List<Boss> findBossInfoByOrder(Integer userId);

    List<Boss> getBossInfoByOrder(Integer userId);

    List<Boss> fingMyBossCollect(Integer userId);


}