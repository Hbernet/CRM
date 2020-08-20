package com.hb.usual.service;

import com.hb.usual.bean.Task;
import com.hb.usual.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-08 14:45
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    TaskMapper taskMapper;

    @Override
    public boolean saveTask(Task task) {
        //获取员工json   Gson 转成对象
        //task.setEmpFk(emp.getEmpFK)
        //设置任务发布的员工
        task.setEmpFk(1);
        //设置任务的状态
        task.setStatus(0);
        return taskMapper.insert(task)>0;
    }

    @Override
    public List<Task> showTask(int eid) {
        return taskMapper.showTask(eid);
    }

    @Override
    public List<Task> showMyTask(int eid) {
        return taskMapper.showMyTask(eid);
    }

    @Override
    public boolean updateTaskStatus(Task task) {
        return taskMapper.updateByPrimaryKeySelective(task)>0;
    }
}
