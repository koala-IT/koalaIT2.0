package com.koalaIT.common.controller;


import com.koalaIT.common.biz.BaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by shen on 2020-06-01.
 */
public abstract class BaseController<T,E> {

    private BaseService<T,E> bizService;

    public BaseService<T, E> getBizService() {
        return bizService;
    }

    public void setBizService(BaseService<T, E> bizService) {
        this.bizService = bizService;
    }

    public Integer countByExample(E example){
        Integer count = 0;
        if (example != null){
            count = this.bizService.countByExample(example);
        }
        return count;
    }

    public void deleteByExample(E example){
        if (example != null){
            this.bizService.deleteByExample(example);
        }
    }

    public void deleteByPrimaryKey(Integer recordId){
        if (recordId != null /*&& !recordId.equals("")*/){
            this.bizService.deleteByPrimaryKey(recordId);
        }
    }

    public void insert(T record){
        if (record != null){
            this.bizService.insert(record);
        }
    }

    public void insertSelective(T record){
        if (record != null){
            this.bizService.insertSelective(record);
        }
    }

    public List<? extends T> selectByExample(E example){
        List<? extends T> list = null;
        if (example != null){
            list = this.bizService.selectByExample(example);
        }
        return list;
    }

    public T selectByPrimaryKey(Integer recordId){
        T t = null;
        if (recordId != null /*&& !recordId.equals("")*/){
            t = (T)this.bizService.selectByPrimaryKey(recordId);
        }
        return t;
    }

    public void updateByExampleSelective(@Param("record") T record, @Param("example") E example){
        if (record != null && example != null){
            this.bizService.updateByExampleSelective(record,example);
        }
    }

    public void updateByExample(@Param("record") T record, @Param("example") E example){
        if (record != null && example != null){
            this.bizService.updateByExample(record,example);
        }
    }

    public void updateByPrimaryKeySelective(T record){
        if (record != null){
            this.bizService.updateByPrimaryKeySelective(record);
        }
    }

    public void updateByPrimaryKey(T record){
        if (record != null){
            this.bizService.updateByPrimaryKey(record);
        }
    }
}