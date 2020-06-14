package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.ManagerMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(ManagerService.class);

    @Autowired
    private ManagerMapper<T,E> managerMapper;

    public ManagerService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }



    public ManagerMapper<T, E> getManagerMapper() {
        return managerMapper;
    }

    public void setManagerMapper(ManagerMapper<T, E> managerMapper) {
        this.managerMapper = managerMapper;
    }
}
