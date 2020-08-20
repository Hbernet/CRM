package com.hb.usual.service;

import com.hb.usual.bean.Notice;
import com.hb.usual.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-09 10:22
 */
@Service
public class NoticeServiceImpl implements NoticeService{

    @Resource
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> showAll() {
        return noticeMapper.showAll();
    }

    @Override
    public boolean saveinfo(Notice notice) {
        return noticeMapper.insert(notice)>0;
    }

    @Override
    public List<Notice> showMainPage() {
        return noticeMapper.showMainPage();
    }

    @Override
    public Notice showOneInfo(int nid) {
        return noticeMapper.selectByPrimaryKey(nid);
    }
}
