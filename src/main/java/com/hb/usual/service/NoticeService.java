package com.hb.usual.service;

import com.hb.usual.bean.Notice;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-09 10:22
 */
public interface NoticeService {
    List<Notice> showAll();

    boolean saveinfo(Notice notice);

    List<Notice> showMainPage();

    Notice showOneInfo(int nid);
}
