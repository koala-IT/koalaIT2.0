package com.koalaIT.common.mapper;

import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Hunterconnect;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HunterconnectMapper <T extends BaseDO, E extends BaseExample> extends BaseMapper<T,E>{

    List<Hunterconnect> findHunterByID(Integer user_id);

    List<Hunterconnect> addCheck(Integer user_id);


}