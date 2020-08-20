package com.hb.pro.controller;

import com.hb.pro.bean.Analysis;
import com.hb.pro.service.AnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-06 15:31
 */
@Controller
@RequestMapping("/ana")
public class AnalysisController {

    @Resource
    private AnalysisService analysisService;

    @RequestMapping("showAllAnaInfo")
    @ResponseBody
    public List<Analysis> showAllAnaInfo() {

        List<Analysis> analyses = analysisService.selectAll();
        return analyses;
    }


    @RequestMapping("saveInfo")
    public String saveInfo(Analysis analysis , MultipartFile file){

        String path="E:\\analysis\\";
        if (file.getSize()>0){
            path+= file.getOriginalFilename();
            try {
                file.transferTo(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        analysis.setAddtime(new Date());
        analysis.setProname(path);
        boolean b = analysisService.saveInfo(analysis);
        if (b){
            return "project-need";
        }else {
            return "error";
        }
    }

    @RequestMapping("getAnaInfo")
    @ResponseBody
    public Analysis getAnaInfo(@RequestParam(value = "pid") Integer id){

        Analysis analysis = analysisService.getAnaInfo(id);

        System.out.println(analysis);

        return analysis;
    }

    @RequestMapping("showModInfo")
    @ResponseBody
    public List<Analysis> showModInfo(){

        List<Analysis> analyses = analysisService.showModInfo();
        return  analyses;
    }

    @RequestMapping("getAnaInfoAndMod")
    @ResponseBody
    public Analysis getAnaInfoAndMod(@RequestParam(value = "pid") Integer id){

        Analysis analysis = analysisService.getAnaInfoAndMod(id);

        System.out.println(analysis);

        return analysis;
    }
}
