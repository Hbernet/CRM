package com.hb.pro.service;

import com.hb.pro.bean.Function;
import com.hb.pro.mapper.FunctionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-03 16:21
 */
@Service
public class FunctionServiceImpl implements FunctionService{

    @Resource
    private FunctionMapper functionMapper;
    @Override
    public List<Function> selectAll() {
        List<Function> functions = functionMapper.selectAll();
        return functions;
    }

    @Override
    public boolean insertSelective(Function function) {
        int i = functionMapper.insertSelective(function);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Function> getFuncByMid(Integer mid) {
        List<Function> functions=functionMapper.getFuncByMid(mid);
        return functions;
    }
}
