package com.hb.usual.service;

import com.hb.usual.bean.Email;
import com.hb.usual.mapper.EmailMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hb
 * @create 2020-07-12 9:18
 */
@Service
public class EmailServiceImpl implements EmailService{

    @Resource
    private EmailMapper emailMapper;

    @Override
    public int saveEmailMsg(Email email) {
        emailMapper.saveEmailMsg(email);
        return 0;
    }
}
