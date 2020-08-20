package com.hb.cus.service;

import com.hb.cus.bean.Customer;
import com.hb.cus.bean.CustomerVO;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-01 19:50
 */
public interface CustomerService {
    boolean insert(Customer customer);

    List<Customer> selectAll(CustomerVO vo);

    List<Customer> queryAll();

    Customer selectOne(Integer id);

    boolean update(Customer customer);

    boolean bachDelete(List<Integer> ids);

    List<Customer> getOthers(Integer pid);

}
