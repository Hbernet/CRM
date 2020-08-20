package com.hb.pro.service;

import com.hb.pro.bean.Analysis;
import com.hb.pro.bean.Module;
import com.hb.pro.mapper.AnalysisMapper;
import com.hb.pro.mapper.ModuleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-03 12:50
 */
@Service
public class ModulServiceImpl implements ModulService{

    @Resource
    ModuleMapper moduleMapper;
    @Override
    public List<Module> selectAll() {
        List<Module> modules = moduleMapper.selectAll();
        return modules;
    }

    @Override
    public boolean saveInfo(Module module) {
        int i = moduleMapper.insert(module);
        if (i>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public List<Module> selectMore(Integer id) {
        List<Module> modules = moduleMapper.selectMore(id);
        return modules;
    }
}
