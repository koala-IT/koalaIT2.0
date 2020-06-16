package com.koalaIT.common.mapper;

import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import com.koalaIT.common.model.Resume;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeMapper <T extends BaseDO, E extends BaseExample> extends BaseMapper<T,E>{
    Resume findResumeByName(String userName);

}