package com.hb.usual.controller;

import com.hb.usual.bean.Baoxiao;
import com.hb.usual.service.BaoXiaoService;
import com.hb.util.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-09 14:53
 */
@Controller
@RequestMapping("/baoxiao")
public class BaoXiaoController {

    @Resource
    private BaoXiaoService baoXiaoService;

    @RequestMapping("getAllBaoxiao")
    @ResponseBody
    public List<Baoxiao> getAllBaoxiao(){
        List<Baoxiao> baoxiaos = baoXiaoService.getAllBaoxiao();

        return baoxiaos;
    }

    @RequestMapping("getOneBaoXiaoByid")
    @ResponseBody
    public Baoxiao getOneBaoXiaoByid(String bxid){
        Baoxiao baoxiao = baoXiaoService.getOneBaoXiaoByid(bxid);
        return baoxiao;
    }

    @RequestMapping("shenpi")
    @ResponseBody
    public ResultInfo shenpi(Baoxiao baoxiao,String content){
        boolean b = baoXiaoService.shenpi(baoxiao,content);
        ResultInfo resultInfo = new ResultInfo();
        if (b){
            resultInfo.setFlag(true);
        }
        return resultInfo;
    }

    @RequestMapping("getBaoByid")
    @ResponseBody
    public List<Baoxiao> getBaoByid(Integer eid){
        List<Baoxiao> baoxiaos = baoXiaoService.getBaoByid(eid);
        return baoxiaos;
    }
}
