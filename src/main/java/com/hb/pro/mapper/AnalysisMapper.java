package com.hb.pro.mapper;

import com.hb.pro.bean.Analysis;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-02 17:06
 */
public interface AnalysisMapper {
    List<Analysis> selectAll();

    Analysis selectOne(Integer id);


    int saveInfo(Analysis analysis);

    List<Analysis> showModInfo();

    Analysis getAnaInfoAndMod(Integer id);
}
