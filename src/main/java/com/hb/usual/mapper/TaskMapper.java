package com.hb.usual.mapper;


import com.hb.usual.bean.Task;

import java.util.List;

public interface TaskMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> showTask(int eid);

    List<Task> showMyTask(int eid);
}