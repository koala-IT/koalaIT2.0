package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.HunterconnectMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HunterconnectService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(HunterconnectService.class);

    @Autowired
    private HunterconnectMapper<T,E> hunterconnectMapper;

    public HunterconnectService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }

    public HunterconnectMapper<T, E> getHunterconnectMapper() {
        return hunterconnectMapper;
    }

    public void setHunterconnectMapper(HunterconnectMapper<T, E> hunterconnectMapper) {
        this.hunterconnectMapper = hunterconnectMapper;
    }
}
