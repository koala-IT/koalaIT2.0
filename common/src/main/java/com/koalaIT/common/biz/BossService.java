package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.BossMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Boss;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BossService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(BossService.class);

    @Autowired
    private BossMapper<T,E> bossMapper;
    @Autowired
    private Boss boss;

    public BossService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }

    public BossMapper<T, E> getBossMapper() {
        return bossMapper;
    }

    public List<Boss> getBossInfo(String bossTitle){
        List<Boss> list = null;
        try{
            if (this.bossMapper == null) {
                this.bossMapper = this.getBossMapper();
            }
            if (bossTitle!= null && this.bossMapper != null){
                list = this.bossMapper.searchBossInfo(bossTitle);
            }
        }catch(Exception e){
            logger.error("查询"+ boss.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return list;
    }

    public List<Boss> getBossByUser(Integer userId){
        List<Boss> list = null;
        try{
            if (this.bossMapper == null) {
                this.bossMapper = this.getBossMapper();
            }
            if (userId!= null && this.bossMapper != null){
                list = this.bossMapper.getBossByUser(userId);
            }
        }catch(Exception e){
            logger.error("查询"+ boss.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return list;
    }

    public List<Boss> findBossByOrder(Integer userId){
        List<Boss> list = null;
        try{
            if (this.bossMapper == null) {
                this.bossMapper = this.getBossMapper();
            }
            if (userId!= null && this.bossMapper != null){
                list = this.bossMapper.findBossInfoByOrder(userId);
            }
        }catch(Exception e){
            logger.error("查询"+ boss.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return list;
    }

    public List<Boss> getBossByOrder(Integer userId){
        List<Boss> list = null;
        try{
            if (this.bossMapper == null) {
                this.bossMapper = this.getBossMapper();
            }
            if (userId!= null && this.bossMapper != null){
                list = this.bossMapper.getBossInfoByOrder(userId);
            }
        }catch(Exception e){
            logger.error("查询"+ boss.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return list;
    }



    public void setBossMapper(BossMapper<T, E> bossMapper) {
        this.bossMapper = bossMapper;
    }
}
