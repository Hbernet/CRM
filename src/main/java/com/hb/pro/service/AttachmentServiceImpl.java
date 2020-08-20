package com.hb.pro.service;

import com.hb.pro.bean.Attachment;
import com.hb.pro.mapper.AttachmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-03 17:09
 */
@Service
public class AttachmentServiceImpl implements AttachmentService{

    @Resource
    private AttachmentMapper attachmentMapper;
    @Override
    public List<Attachment> showAllInfo() {
        List<Attachment> attachments = attachmentMapper.selectAll();
        return attachments;
    }


    @Override
    public boolean saveInfo(Attachment attachment) {
       int i= attachmentMapper.saveInfo(attachment);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String getPath(int id) {
       String filePath= attachmentMapper.getPath(id);
        return filePath;
    }
}
