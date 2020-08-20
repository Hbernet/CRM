package com.hb.pro.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hb.pro.bean.Module;
import com.hb.pro.bean.ModuleVO;
import com.hb.pro.service.ModulService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-06 15:34
 */
@Controller
@RequestMapping("/mod")
public class ModuleController {
    @Resource
    private ModulService modulService;

    @RequestMapping("showAllModInfo")
    @ResponseBody
    public PageInfo<Module> showAllModInfo(@RequestParam(value = "currentpage") Integer pageNum, ModuleVO vo) {
        System.out.println(pageNum);
        System.out.println(vo);
        if (vo.getNum()==1){
            String orderBy="addtime desc";
            PageHelper.startPage(pageNum,3,orderBy);
        }else if (vo.getNum()==2){
            String orderBy="updatetime desc";
            PageHelper.startPage(pageNum,3,orderBy);
        }else {
            PageHelper.startPage(pageNum,3);
        }

        List<Module> modules = modulService.selectAll();
        PageInfo<Module> pageInfo = new PageInfo<>(modules);

        return pageInfo;
    }

    @RequestMapping("saveInfo")
    public String saveInfo(Module module){

        boolean b = modulService.saveInfo(module);
        if (b){
            return "project-model";
        }else {
            return "error";
        }

    }

    @RequestMapping("getModInfo")
    @ResponseBody
    public List<Module> getModInfo(Integer id){
        List<Module> modules = modulService.selectMore(id);
        return modules;
    }
}
