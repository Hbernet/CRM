package com.hb.cus.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hb.cus.bean.Customer;
import com.hb.cus.bean.CustomerVO;
import com.hb.cus.service.CustomerService;
import com.hb.util.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author hb
 * @create 2020-07-01 19:16
 */
@Controller
@RequestMapping("/cus")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @RequestMapping("saveCustomer")
    public String saveCustomer(Customer customer){
        customer.setAddtime(new Date());
        boolean b = customerService.insert(customer);
        if (b){
            return "customer";
        }else {
            return "error";
        }
    }
    @RequestMapping("showInfo")
    @ResponseBody
    public PageInfo<Customer> showInfo(@RequestParam(value = "currentpage") Integer pageNum, CustomerVO vo){
        Integer num = vo.getNum();
        if (num==1){
            String orderBy="id desc";
            PageHelper.startPage(pageNum,3,orderBy);
        }else {
            PageHelper.startPage(pageNum,3);
        }

        List<Customer> customers = customerService.selectAll(vo);
        PageInfo<Customer> pageInfo = new PageInfo<>(customers);
        return pageInfo;
    }

    @RequestMapping("showAllInfo")
    @ResponseBody
    public List<Customer> showAllInfo(){
        List<Customer> customers = customerService.queryAll();
        return customers;
    }

    @RequestMapping("getOneInfo")
    @ResponseBody
    public Customer getOneInfo(Integer id){
        Customer customer = customerService.selectOne(id);
        return customer;
    }


    @RequestMapping("getOtherInfo")
    @ResponseBody
    public List<Customer> getOtherInfo(@RequestParam(value = "id") Integer pid){

        List<Customer> customers = customerService.getOthers(pid);
        return  customers;
    }

    @RequestMapping("updateInfo")
    public String updateInfo(Customer customer){
        customer.setAddtime(new Date());
        boolean b = customerService.update(customer);
        if (b){
            return "customer";
        }else {
            return  "error";
        }

    }

    @RequestMapping("bachDelete")
    @ResponseBody
    public ResultInfo bachDelete(String ids){
        String[] idss = ids.split(",");
        List<Integer> list=new ArrayList<>();
        for (String s : idss) {
            int i = Integer.parseInt(s);
            list.add(i);
        }

        ResultInfo resultInfo = new ResultInfo();
        boolean b = customerService.bachDelete(list);
        if (b){
           resultInfo.setFlag(true);
        }else {
            resultInfo.setFlag(false);
        }
        return resultInfo;
    }

}
