package com.hb.pro.service;

import com.hb.pro.bean.Analysis;
import com.hb.pro.bean.Module;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-03 12:49
 */
public interface ModulService {
    List<Module> selectAll();

    boolean saveInfo(Module module);

    List<Module> selectMore(Integer id);
}
