package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.BossconnectMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Bossconnect;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Bossconnect> findBossByID(Integer userId){
        List<Bossconnect> list = null;
        try{
            if (this.bossconnectMapper == null) {
                this.bossconnectMapper = this.getBossconnectMapper();
            }
            if (userId!= null && this.bossconnectMapper != null){
                list = this.bossconnectMapper.findBossByID(userId);
            }
        }catch(Exception e){
            logger.error("查询"+ bossconnectMapper.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return list;
    }

    public Integer delBossInfo(Bossconnect bossconnect){
        Integer i = null;
        try{
            if (this.bossconnectMapper == null) {
                this.bossconnectMapper = this.getBossconnectMapper();
            }
            if (bossconnect!= null && this.bossconnectMapper != null){
                i = this.bossconnectMapper.delBossConnect(bossconnect);
            }
        }catch(Exception e){
            logger.error("查询"+ bossconnectMapper.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return i;

    }

    public List<Bossconnect> addCheck(Bossconnect bossconnect){
        List<Bossconnect> list = null;

        list = this.bossconnectMapper.addCheck(bossconnect);

        return list;
    }


    public void setBossconnectMapper(BossconnectMapper<T,E> bossconnectMapper){
        this.bossconnectMapper = bossconnectMapper;
    }

}
