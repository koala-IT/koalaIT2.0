package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.BosscollectMapper;
import com.koalaIT.common.mapper.SysLogMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BosscollectService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E> {
    private Logger logger = Logger.getLogger(BosscollectService.class);

    @Autowired
    private BosscollectMapper<T,E> bosscollectMapper;

    public BosscollectService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }

    public BosscollectMapper<T,E> getBosscollectMapper(){
        return bosscollectMapper;
    }

    public void setBosscollectMapper(SysLogMapper<T, E> sysLogMapper) {
        this.bosscollectMapper = bosscollectMapper;
    }


}
