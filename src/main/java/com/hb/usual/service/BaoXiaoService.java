package com.hb.usual.service;

import com.hb.usual.bean.Baoxiao;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-09 14:53
 */
public interface BaoXiaoService {
    List<Baoxiao> getAllBaoxiao();

    Baoxiao getOneBaoXiaoByid(String bxid);

    boolean shenpi(Baoxiao baoxiao, String content);

    List<Baoxiao> getBaoByid(Integer eid);
}
