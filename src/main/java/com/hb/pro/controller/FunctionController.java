package com.hb.pro.controller;

import com.hb.pro.bean.Function;
import com.hb.pro.service.FunctionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-06 15:36
 */
@Controller
@RequestMapping("/fun")
public class FunctionController {



    @Resource
    private FunctionService functionService;

    @RequestMapping("showAllFunInfo")
    @ResponseBody
    public List<Function> showAllFunInfo() {

        List<Function> functions = functionService.selectAll();

        return functions;
    }

    @RequestMapping("saveInfo")
    public String saveInfo(Function function,String newproname){

        System.out.println(newproname);
        function.setProname(newproname.split(",")[0]);

        boolean b = functionService.insertSelective(function);

        if (b) {
            return "project-function";
        } else {
            return "error";
        }
    }

    @RequestMapping("getFuncByMid")
    @ResponseBody
    public List<Function> getFuncByMid(String mid){
        int i = Integer.parseInt(mid);
        List<Function> functions=functionService.getFuncByMid(i);
        return functions;
    }

}
