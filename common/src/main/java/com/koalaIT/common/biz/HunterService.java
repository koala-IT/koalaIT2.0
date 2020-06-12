package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.HunterMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HunterService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(HunterService.class);

    @Autowired
    private HunterMapper<T,E> hunterMapper;

    public HunterService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }

    //查询
    public HunterMapper<T,E> getHunterByUser(){
        return hunterMapper;
    }

    public void setHunterMapper (HunterMapper<T,E> hunterMapper){
        this.hunterMapper = hunterMapper;
    }





}
