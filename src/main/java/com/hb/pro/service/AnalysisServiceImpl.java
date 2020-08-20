package com.hb.pro.service;

import com.hb.pro.bean.Analysis;
import com.hb.pro.mapper.AnalysisMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-03 10:44
 */
@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Resource
    private AnalysisMapper analysisMapper;
    @Override
    public List<Analysis> selectAll() {
        List<Analysis> analyses = analysisMapper.selectAll();
        return analyses;
    }

    @Override
    public boolean saveInfo(Analysis analysis) {
        int i = analysisMapper.saveInfo(analysis);
        if (i>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Analysis getAnaInfo(Integer id) {
        Analysis analysis = analysisMapper.selectOne(id);
        return analysis;
    }

    @Override
    public List<Analysis> showModInfo() {
        List<Analysis> analyses = analysisMapper.showModInfo();
        return analyses;
    }

    @Override
    public Analysis getAnaInfoAndMod(Integer id) {
        Analysis analysis=analysisMapper.getAnaInfoAndMod(id);
        return analysis;
    }
}
