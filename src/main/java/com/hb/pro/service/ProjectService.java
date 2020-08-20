package com.hb.pro.service;

import com.hb.pro.bean.Project;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-03 10:02
 */
public interface ProjectService {
    List<Project> selectAll();

    Project selectOne(Integer pid);

    boolean savepro(Project project);

    int getComname(Integer pid);

    int getEmpfk(Integer pid);

    boolean updatePro(Project project);

    boolean bachDelete(List<Integer> list);

    List<Project> showNoInfo();

    List<Project> showAnaInfo();

    List<Project> showAll();

    List<Project> showProWithFunction();
}
