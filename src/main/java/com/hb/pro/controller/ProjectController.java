package com.hb.pro.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hb.emp.bean.Employee;
import com.hb.pro.bean.*;
import com.hb.pro.service.*;
import com.hb.util.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-03 9:59
 */
@Controller
@RequestMapping("/pro")
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @RequestMapping("showAllProInfo")
    @ResponseBody
    public PageInfo<Project> showAllProInfo(@RequestParam(value = "currentpage") Integer pageNum) {
        PageHelper.startPage(pageNum, 3);
        List<Project> projects = projectService.selectAll();
        PageInfo<Project> pageInfo = new PageInfo<>(projects);
        return pageInfo;
    }

    @RequestMapping("showAll")
    @ResponseBody
    public List<Project> showAll(){
        List<Project> projects = projectService.showAll();
        return projects;
    }

    @RequestMapping("showOneInfo")
    @ResponseBody
    public Project showOneInfo(@RequestParam(value = "id") Integer pid) {
        Project project = projectService.selectOne(pid);
        return project;
    }


    @RequestMapping("savePro")
    public String savePro(String newcomname, Project project) {
        int comname = Integer.parseInt(newcomname.split(",")[0]);
        project.setComname(comname);
        boolean b = projectService.savepro(project);
        if (b) {
            return "project-base";
        } else {
            return "error";
        }
    }

    @RequestMapping("updatePro")
    public String updatePro(String newcomname, Project project) {
        int comname = Integer.parseInt(newcomname.split(",")[0]);
        project.setComname(comname);
        boolean b = projectService.updatePro(project);
        if (b) {
            return "project-base";
        } else {
            return "error";
        }
    }

    @RequestMapping("bachDelete")
    @ResponseBody
    public ResultInfo bachDelete(String ids) {
        List<Integer> list = new ArrayList<>();
        String[] split = ids.split(",");
        for (String s : split) {
            list.add(Integer.parseInt(s));
        }
        boolean b = projectService.bachDelete(list);
        ResultInfo resultInfo = new ResultInfo();
        if (b) {
            resultInfo.setFlag(true);
        } else {
            resultInfo.setFlag(false);
        }
        return resultInfo;
    }

    @RequestMapping("showNoInfo")
    @ResponseBody
    public List<Project> showNoInfo(){
        List<Project> projects = projectService.showNoInfo();
        return projects;
    }

    @RequestMapping("showAnaInfo")
    @ResponseBody
    public List<Project> showAnaInfo(){
        List<Project> projects = projectService.showAnaInfo();
        return projects;
    }

    @RequestMapping("showProWithFunction")
    @ResponseBody
    public List<Project> showProWithFunction0(){
        List<Project> projects=projectService.showProWithFunction();
        return projects;
    }


}
