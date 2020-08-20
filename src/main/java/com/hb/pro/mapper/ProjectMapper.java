package com.hb.pro.mapper;

import com.hb.pro.bean.Project;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-02 17:06
 */
public interface ProjectMapper {
    List<Project> selectAll();

    Project selectOne(Integer pid);

    int insert(Project project);

    int getComname(Integer pid);

    int getEmpfk(Integer pid);

    int updatePro(Project project);

    int bachDelete(List<Integer> list);

    List<Project> showNoInfo();

    List<Project> showAnaInfo();

    List<Project> showAll();

    List<Project> showProWithFunction();
}
