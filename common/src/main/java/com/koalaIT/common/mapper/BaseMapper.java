package com.koalaIT.common.mapper;

import com.koalaIT.common.querypage.QueryPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;



public interface BaseMapper<T,E> {

    int countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(Integer smsCodeId);

    int insert(T record);

    int insertSelective(T record);

    List<? extends T> selectByExample(E example);

    T selectByPrimaryKey(Integer smsCodeId);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    int getQueryTotalCount(Map map);

    List<? extends T> getQueryPageList(Map map, QueryPage page);
}
