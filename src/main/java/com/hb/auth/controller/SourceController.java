package com.hb.auth.controller;

import com.hb.auth.bean.Sources;
import com.hb.auth.service.SourcesService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * @author hb
 * @create 2020-07-13 10:31
 */
@Controller
@RequestMapping("auth")
public class SourceController {

    @Resource
    private SourcesService sourcesService;

    @RequestMapping("getRootSources")
    @ResponseBody
    public Sources getRootSources(){
        Sources rootSources = sourcesService.getRootSources();
        return rootSources;
    }

    @RequestMapping("addSources")
    public String addSources(Sources sources){
        boolean b=sourcesService.addSources(sources);
        if (b){
            return "redirct:/pm";
        }else {
            return "error";
        }
    }
}

