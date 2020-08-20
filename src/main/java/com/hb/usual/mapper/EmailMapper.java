package com.hb.usual.mapper;

import com.hb.usual.bean.Email;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmailMapper {

    int  saveEmailMsg(Email email);
}