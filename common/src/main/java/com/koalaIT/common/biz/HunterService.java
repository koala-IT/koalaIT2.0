package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.HunterMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Hunter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HunterService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(HunterService.class);

    @Autowired
    private HunterMapper<T,E> hunterMapper;
    @Autowired
    private Hunter hunter;

    public HunterService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }

    public HunterMapper<T, E> getHunterMapper() {
        return hunterMapper;
    }

    public void setHunterMapper (HunterMapper<T,E> hunterMapper){
        this.hunterMapper = hunterMapper;
    }

    public List<Hunter> selectByUser_id(Integer userId){
        List<Hunter> list = null;
        try{
            if (this.hunterMapper == null) {
                this.hunterMapper = this.getHunterMapper();
            }
            if (userId!= null && this.hunterMapper != null){
                list = this.hunterMapper.getHunterByUser(userId);
            }
        }catch(Exception e){
            logger.error("查询"+ hunter.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return list;
    }

    public List<Hunter> selectHunterInfoByOrder(Integer userId){
        List<Hunter> list = null;
        try{
            if (this.hunterMapper == null) {
                this.hunterMapper = this.getHunterMapper();
            }
            if (userId!= null && this.hunterMapper != null){
                list = this.hunterMapper.findHunterInfoByOrder(userId);
            }
        }catch(Exception e){
            logger.error("查询"+ hunter.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return list;
    }

    public List<Hunter> selectHunterInfoByOrdered(Integer userId){
        List<Hunter> list = null;
        try{
            if (this.hunterMapper == null) {
                this.hunterMapper = this.getHunterMapper();
            }
            if (userId!= null && this.hunterMapper != null){
                list = this.hunterMapper.getHunterInfoByOrder(userId);
            }
        }catch(Exception e){
            logger.error("查询"+ hunter.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return list;
    }

    public List<Hunter> getMyHunterCollect(Integer userId){
        List<Hunter> list = null;
        try{
            if (this.hunterMapper == null) {
                this.hunterMapper = this.getHunterMapper();
            }
            if (userId!= null && this.hunterMapper != null){
                list = this.hunterMapper.fingMyHunterCollect(userId);
            }
        }catch(Exception e){
            logger.error("查询"+ hunter.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return list;
    }











}
