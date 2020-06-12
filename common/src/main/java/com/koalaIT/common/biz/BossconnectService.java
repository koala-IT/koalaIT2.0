package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.BossconnectMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BossconnectService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(HunterService.class);

    @Autowired
    private BossconnectMapper<T,E> bossconnectMapper;

    public BossconnectService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }

    public BossconnectMapper<T,E> getBossconnectMapper(){
        return bossconnectMapper;
    }

    public void setBossconnectMapper(BossconnectMapper<T,E> bossconnectMapper){
        this.bossconnectMapper = bossconnectMapper;
    }

}
