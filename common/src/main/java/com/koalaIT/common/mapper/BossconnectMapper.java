package com.koalaIT.common.mapper;

import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import org.springframework.stereotype.Repository;

@Repository
public interface BossconnectMapper <T extends BaseDO, E extends BaseExample> extends BaseMapper<T,E>{

}