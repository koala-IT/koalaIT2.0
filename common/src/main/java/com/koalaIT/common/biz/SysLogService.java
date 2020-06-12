package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.SysLogMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(SysLogService.class);

    @Autowired
    private SysLogMapper<T,E> sysLogMapper;

    public SysLogService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }

    public SysLogMapper<T, E> getSysLogMapper() {
        return sysLogMapper;
    }

    public void setSysLogMapper(SysLogMapper<T, E> sysLogMapper) {
        this.sysLogMapper = sysLogMapper;
    }


}
