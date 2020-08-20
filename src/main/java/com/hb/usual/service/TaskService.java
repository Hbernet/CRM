package com.hb.usual.service;

import com.hb.usual.bean.Task;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-08 14:45
 */
public interface TaskService {
    boolean saveTask(Task task);

    List<Task> showTask(int eid);

    List<Task> showMyTask(int eid);

    boolean updateTaskStatus(Task task);
}
