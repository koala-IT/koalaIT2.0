package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.BossMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BossService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(BossService.class);

    @Autowired
    private BossMapper<T,E> bossMapper;

    public BossService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }

    public BossMapper<T, E> getBossMapper() {
        return bossMapper;
    }

    public void setBossMapper(BossMapper<T, E> bossMapper) {
        this.bossMapper = bossMapper;
    }
}
