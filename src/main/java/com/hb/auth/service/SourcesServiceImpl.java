package com.hb.auth.service;

import com.hb.auth.bean.Sources;
import com.hb.auth.mapper.SourcesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-13 10:54
 */
@Service
public class SourcesServiceImpl implements SourcesService {
    @Resource
    private SourcesMapper sourcesMapper;
    @Override
    public Sources getRootSources() {
        Sources sources=sourcesMapper.getRootSources();
        sources.setOpen(true);
        return getChild(sources);
    }

    @Override
    public boolean addSources(Sources sources) {

        return sourcesMapper.addSources(sources)>0;
    }

    public Sources getChild(Sources sources){
        List<Sources> child=sourcesMapper.getChild(sources.getId());
        if (child!=null&&child.size()>0){
            sources.setChildren(child);
            for (int i=0;i<child.size();i++){
                Sources sources1 = child.get(i);
                getChild(sources1);
            }
        }
        return sources;
    }
}
