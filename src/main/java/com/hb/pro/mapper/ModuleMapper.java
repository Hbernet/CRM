package com.hb.pro.mapper;

import com.hb.pro.bean.Module;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-02 17:06
 */
public interface ModuleMapper {
    List<Module> selectAll();

    Module selectOne(Integer id);

    int insert(Module module);

    List<Module> selectMore(Integer id);
}
