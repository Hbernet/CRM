package com.hb.pro.service;

import com.hb.pro.bean.Attachment;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-03 17:09
 */
public interface AttachmentService {
    List<Attachment> showAllInfo();

    boolean saveInfo(Attachment attachment);

    String getPath(int id);
}
