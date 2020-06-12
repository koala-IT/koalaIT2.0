package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.CheckconnectMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckconnectService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(CheckconnectService.class);

    @Autowired
    private CheckconnectMapper<T,E> checkconnectMapper;

    public CheckconnectService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }

    public CheckconnectMapper<T, E> getCheckconnectMapper() {
        return getCheckconnectMapper();
    }

    public void setCheckconnectMapper(CheckconnectMapper<T, E> checkconnectMapper) {
        this.checkconnectMapper = checkconnectMapper;
    }
}
