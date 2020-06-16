package com.koalaIT.common.mapper;

import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Hunter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HunterMapper <T extends BaseDO, E extends BaseExample> extends BaseMapper<T,E>{
    List<Hunter> getHunterByUser(Integer userId);

    List<Hunter> findHunterInfoByOrder(Integer userId);

    List<Hunter> getHunterInfoByOrder(Integer userId);


}