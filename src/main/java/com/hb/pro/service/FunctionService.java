package com.hb.pro.service;

import com.hb.pro.bean.Function;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-03 16:21
 */
public interface FunctionService {
    List<Function> selectAll();

    boolean insertSelective(Function function);

    List<Function> getFuncByMid(Integer mid);
}
