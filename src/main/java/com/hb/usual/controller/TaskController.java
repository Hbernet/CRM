package com.hb.usual.controller;

import com.hb.usual.bean.Task;
import com.hb.usual.service.TaskService;
import com.hb.util.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-08 14:44
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskService taskService;

    @RequestMapping("addInfo")
    public String saveTask(Task task){

        boolean b = taskService.saveTask(task);

        if (b){
            return "redirect:/task.jsp";
        }else {
            return "redirect:/error.jsp";
        }
    }

    @RequestMapping("showTask")
    @ResponseBody
    public List<Task> showTask(){
        //Jedis获取id
        return taskService.showTask(1);
    }
    @RequestMapping("showMyTask")
    @ResponseBody
    public List<Task> showMyTask(){
        //Jedis获取id
        return taskService.showMyTask(5);
    }

    @RequestMapping("updateTaskStatus")
    @ResponseBody
    public ResultInfo updateTaskStatus(Task task){
        boolean b = taskService.updateTaskStatus(task);
        ResultInfo resultInfo = new ResultInfo();
        if (b){
            resultInfo.setFlag(b);
        }
        return resultInfo;
    }
}
