package com.koalaIT.common.biz;

import com.koalaIT.common.mapper.UserMapper;
import com.koalaIT.common.model.BaseDO;
import com.koalaIT.common.model.BaseExample;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService <T extends BaseDO,E extends BaseExample> extends BaseService<T,E>{
    private Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private UserMapper<T,E> userMapper;

    public UserService(){
        if (logger != null){
            this.setLogger(logger);
        }
    }

    public UserMapper<T, E> getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper<T, E> userMapper) {
        this.userMapper = userMapper;
    }
}
