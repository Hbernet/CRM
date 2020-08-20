package com.hb.pro.mapper;

import com.hb.pro.bean.Attachment;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-02 17:06
 */
public interface AttachmentMapper {
    List<Attachment> selectAll();

    int saveInfo(Attachment attachment);

    String getPath(int id);
}
