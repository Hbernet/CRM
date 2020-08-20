package com.hb.cus.mapper;

import com.hb.cus.bean.Customer;
import com.hb.cus.bean.CustomerVO;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-01 19:48
 */
public interface CustomerMapper {
    int insert(Customer customer);

    List<Customer> selectAll(CustomerVO vo);

    List<Customer> queryAll();

    Customer selectOne(Integer id);

    int update(Customer customer);

    int bachDelete(List<Integer> ids);

    List<Customer>getOthers(Integer id);
}
