package com.hb.auth.service;

import com.hb.auth.bean.Sources;

/**
 * @author hb
 * @create 2020-07-13 10:54
 */
public interface SourcesService {

    Sources getRootSources();

    boolean addSources(Sources sources);
}
