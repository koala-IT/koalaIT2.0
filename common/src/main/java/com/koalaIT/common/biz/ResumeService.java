package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.ResumeMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Resume;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(ResumeService.class);

    @Autowired
    private ResumeMapper<T,E> resumeMapper;

    public ResumeService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }

    public Resume findResumeByName(String userName){
        Resume resume = null;
        try{
            if (this.resumeMapper == null) {
                this.resumeMapper = this.getResumeMapper();
            }
            if (userName!= null && this.resumeMapper != null){
                resume = this.resumeMapper.findResumeByName(userName);
            }
        }catch(Exception e){
            logger.error("查询"+ resumeMapper.getClass().getName()+"时，出现错误！错误信息："+e.getMessage());
        }
        return resume;
    }

    public ResumeMapper<T, E> getResumeMapper() {
        return resumeMapper;
    }

    public void setResumeMapper(ResumeMapper<T, E> resumeMapper) {
        this.resumeMapper = resumeMapper;
    }
}
