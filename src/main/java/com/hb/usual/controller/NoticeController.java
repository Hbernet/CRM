package com.hb.usual.controller;

import com.hb.usual.bean.Notice;
import com.hb.usual.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-09 10:21
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    NoticeService noticeService;

    @RequestMapping("showAll")
    @ResponseBody
    public List<Notice> showAll(){
        List<Notice> notices = noticeService.showAll();
        return notices;
    }

    @RequestMapping("saveinfo")
    public String saveinfo(Notice notice){
        notice.setNdate(new Date());
        //设置当前登录用户的id为通知公告的员工外键
        //notice.setEmpFk();
        boolean b = noticeService.saveinfo(notice);
        if (b){
            return "redirect:/notice.jsp";
        }else {
            return "error";
        }
    }

    @RequestMapping("showMainPage")
    @ResponseBody
    public List<Notice> showMainPage(){
        return noticeService.showMainPage();
    }

    @RequestMapping("showOneInfo")
    @ResponseBody
    public Notice showOneInfo(int nid){
        return noticeService.showOneInfo(nid);
    }
}
