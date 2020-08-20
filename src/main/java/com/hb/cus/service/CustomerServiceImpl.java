package com.hb.cus.service;

import com.hb.cus.bean.Customer;
import com.hb.cus.bean.CustomerVO;
import com.hb.cus.mapper.CustomerMapper;
import com.hb.pro.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-01 19:50
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public boolean insert(Customer customer) {
        int i = customerMapper.insert(customer);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Customer> selectAll(CustomerVO vo) {
        List<Customer> customers = customerMapper.selectAll(vo);
        return customers;
    }

    @Override
    public List<Customer> queryAll() {
        List<Customer> customers = customerMapper.queryAll();
        return customers;
    }

    @Override
    public Customer selectOne(Integer id) {
        Customer customer = customerMapper.selectOne(id);
        return customer;
    }

    @Override
    public boolean update(Customer customer) {

        int i = customerMapper.update(customer);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean bachDelete(List<Integer> ids) {
        int i = customerMapper.bachDelete(ids);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }

    @Resource
    private ProjectService projectService;

    @Override
    public List<Customer> getOthers(Integer pid) {
        int id = projectService.getComname(pid);
        List<Customer> others = customerMapper.getOthers(id);
        return others;
    }
}
