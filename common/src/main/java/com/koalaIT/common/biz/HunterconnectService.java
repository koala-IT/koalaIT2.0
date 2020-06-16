package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.HunterconnectMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Hunterconnect;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Hunterconnect> findHunterByID(Integer userId){
        List<Hunterconnect> list = null;
        try{
            if (this.hunterconnectMapper == null) {
                this.hunterconnectMapper = this.getHunterconnectMapper();
            }
            if (userId!= null && this.hunterconnectMapper != null){
                list = this.hunterconnectMapper.findHunterByID(userId);
            }
        }catch(Exception e){
            logger.error("查询"+ hunterconnectMapper.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return list;
    }

    public List<Hunterconnect> addCheck(Hunterconnect hunterconnect){
        List<Hunterconnect> list = null;

        list = this.hunterconnectMapper.addCheck(hunterconnect);

        return list;
    }

    public void setHunterconnectMapper(HunterconnectMapper<T, E> hunterconnectMapper) {
        this.hunterconnectMapper = hunterconnectMapper;
    }
}
