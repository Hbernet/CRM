package com.hb.usual.mapper;


import com.hb.usual.bean.Expendituretype;

public interface ExpendituretypeMapper {
    int deleteByPrimaryKey(Integer etid);

    int insert(Expendituretype record);

    int insertSelective(Expendituretype record);

    Expendituretype selectByPrimaryKey(Integer etid);

    int updateByPrimaryKeySelective(Expendituretype record);

    int updateByPrimaryKey(Expendituretype record);
}