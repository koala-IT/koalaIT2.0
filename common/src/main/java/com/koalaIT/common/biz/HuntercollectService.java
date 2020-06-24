package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.HuntercollectMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HuntercollectService<T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(HuntercollectService.class);

    @Autowired
    private HuntercollectMapper<T,E> huntercollectMapper;

    public HuntercollectService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }



    public HuntercollectMapper<T, E> getHuntercollectMapper() {
        return huntercollectMapper;
    }

    public void setHuntercollectMapper(HuntercollectMapper<T, E> huntercollectMapper) {
        this.huntercollectMapper = huntercollectMapper;
    }
}
