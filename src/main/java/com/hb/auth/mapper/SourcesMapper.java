package com.hb.auth.mapper;


import com.hb.auth.bean.Sources;

import java.util.List;


public interface SourcesMapper {

    Sources getRootSources();

    List<Sources> getChild(Integer id);

    int addSources(Sources sources);
}