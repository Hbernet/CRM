package com.hb.pro.service;

import com.hb.pro.bean.Analysis;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-03 10:43
 */
public interface AnalysisService {
    List<Analysis> selectAll();

    boolean saveInfo(Analysis analysis);

    Analysis getAnaInfo(Integer id);

    List<Analysis> showModInfo();

    Analysis getAnaInfoAndMod(Integer id);
}
