package com.hb.pro.service;

import com.hb.pro.bean.Project;
import com.hb.pro.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-03 10:03
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;
    @Override
    public List<Project> selectAll() {
        List<Project> projects = projectMapper.selectAll();
        return projects;
    }

    @Override
    public Project selectOne(Integer pid) {

        Project project = projectMapper.selectOne(pid);
        return project;
    }


    @Override
    public boolean savepro(Project project) {
        int i = projectMapper.insert(project);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int getComname(Integer pid) {
        int comname = projectMapper.getComname(pid);
        return comname;
    }

    @Override
    public int getEmpfk(Integer pid) {
        int fk = projectMapper.getEmpfk(pid);
        return fk;
    }

    @Override
    public boolean updatePro(Project project) {
        int i = projectMapper.updatePro(project);
        if (i>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean bachDelete(List<Integer> list) {
        int i = projectMapper.bachDelete(list);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Project> showNoInfo() {
        List<Project> projects = projectMapper.showNoInfo();
        return projects;
    }

    @Override
    public List<Project> showAnaInfo() {
        List<Project> projects = projectMapper.showAnaInfo();
        return projects;
    }

    @Override
    public List<Project> showAll() {
        List<Project> projects = projectMapper.showAll();
        return projects;
    }

    @Override
    public List<Project> showProWithFunction() {
        List<Project> projects=projectMapper.showProWithFunction();
        return projects;
    }
}
