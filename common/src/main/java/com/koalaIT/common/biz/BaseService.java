package com.koalaIT.common.biz;


import com.koalaIT.common.mapper.BaseMapper;
import com.koalaIT.common.querypage.QueryPage;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

public abstract class BaseService<T,E>  {  /*包括了基础的增删改*/
    private Logger logger;
    private BaseMapper<T,E> entityMapper;
    private T entity;

    public BaseService(){

    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public BaseMapper<T, E> getEntityMapper() {
        return entityMapper;
    }

    public void setEntityMapper(BaseMapper<T, E> entityMapper) {
        this.entityMapper = entityMapper;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public Integer countByExample(E example){
        Integer count = 0;
        try{
            if (example != null && this.entityMapper != null){
                count = this.entityMapper.countByExample(example);
            }
        }catch(Exception e){
            logger.error("查询"+ entity.getClass().getName()+"总数量时，出现错误！错误信息："+e.getMessage());
        }

        return count;
    }

    public void deleteByExample(E example){
        try{
            if (example != null && this.entityMapper != null){
                this.entityMapper.deleteByExample(example);
            }
        }catch(Exception e){
            logger.error("删除"+ entity.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
    }

    public void deleteByPrimaryKey(String recordId){
        try{
            if (recordId != null && !recordId.equals("") && this.entityMapper != null){
                this.entityMapper.deleteByPrimaryKey(recordId);
            }
        }catch(Exception e){
            logger.error("删除"+ entity.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
    }

    public void insert(T record){
        try{
            if (record != null && this.entityMapper != null){
                this.entityMapper.insert(record);
            }
        }catch(Exception e){
            logger.error("增加"+ entity.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
    }

    public void insertSelective(T record){
        try{
            if (record != null && this.entityMapper != null)
                this.entityMapper.insertSelective(record);
        } catch(Exception e){
            logger.error("增加"+ entity.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
    }

    public List<? extends T> selectByExample(E example){
        List<? extends T> list = null;
        try{
            if (this.entityMapper == null) {
                this.entityMapper = this.getEntityMapper();
            }
            if (example != null && this.entityMapper != null){
                list = this.entityMapper.selectByExample(example);
            }
        }catch(Exception e){
            logger.error("查询"+ entity.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return list;
    }

    public T selectByPrimaryKey(String recordId){
        T t = null;
        try{
            if (recordId != null && !recordId.equals("") && this.entityMapper != null){
                t = (T)this.entityMapper.selectByPrimaryKey(recordId);
            }
        }catch(Exception e){
            logger.error("查询"+ entity.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return t;
    }

    public void updateByExampleSelective(@Param("record") T record, @Param("example") E example){
        try{
            if (record != null && example != null && this.entityMapper != null){
                this.entityMapper.updateByExampleSelective(record,example);
            }
        }catch(Exception e){
            logger.error("更新"+ entity.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
    }

    public void updateByExample(@Param("record") T record, @Param("example") E example){
        try{
            if (record != null && example != null && this.entityMapper != null){
                this.entityMapper.updateByExample(record,example);
            }
        } catch(Exception e){
            logger.error("更新"+ entity.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
    }

    public void updateByPrimaryKeySelective(T record){
        try{
            if (record != null && this.entityMapper != null){
                this.entityMapper.updateByPrimaryKeySelective(record);
            }
        }catch(Exception e){
            logger.error("更新"+ entity.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
    }

    public void updateByPrimaryKey(T record){
        try{
            if (record != null && this.entityMapper != null){
                this.entityMapper.updateByPrimaryKey(record);
            }
        }catch(Exception e){
            logger.error("更新"+ entity.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
    }

    public QueryPage getQueryPageList(Map map, QueryPage page) {
        try {
            Integer totalCount = entityMapper.getQueryTotalCount(page.getParameters());
            List<? extends T> entityList = entityMapper.getQueryPageList(map,page);
            page.setItems(entityList);
            page.setTotalCount(totalCount);
        } catch(Exception e) {
            logger.error("分页查询"+ entity.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        } finally {
            return page;
        }
    }
}
