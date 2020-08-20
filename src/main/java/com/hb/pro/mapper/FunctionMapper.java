package com.hb.pro.mapper;

import com.hb.pro.bean.Function;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-02 17:06
 */
public interface FunctionMapper {
    List<Function> selectAll();
    int insertSelective(Function function);

    List<Function> getFuncByMid(Integer mid);
}
