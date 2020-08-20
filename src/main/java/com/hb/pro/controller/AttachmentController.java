package com.hb.pro.controller;

import com.hb.pro.bean.Attachment;
import com.hb.pro.service.AttachmentService;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;


import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-08 9:53
 */
@Controller
@RequestMapping("/atta")
public class AttachmentController {

//    @Resource
//    private JedisPool jedisPool;

    @Resource
    private AttachmentService attachmentService;

    @RequestMapping("showAllInfo")
    @ResponseBody
    public List<Attachment> showAllInfo(){
        List<Attachment> attachments = attachmentService.showAllInfo();

        //缓存下载地址：id作为Key  path作为value缓存
//        if(attachments.size()>0){
//            Jedis jedis = jedisPool.getResource();
//            for (Attachment attachment:attachments){
//                jedis.set(attachment.getId()+"",attachment.getPath());
//            }
//            jedis.close();
//        }

        return attachments;
    }

    @RequestMapping(value = "saveInfo",method = RequestMethod.POST)
    public String saveInfo(Attachment attachment, MultipartFile files){

        //文件上传
        //构建文件位置(目录)
        String path = "E:\\attachment\\";
        if (files.getSize()>0){
            //构建完整路径（目录+名称）
            path += files.getOriginalFilename();
            File newfile = new File(path);
            try {
                //执行文件上传
                files.transferTo(newfile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //数据库中保存数据
        //设置文件上传路径
        attachment.setPath(path);
        boolean b = attachmentService.saveInfo(attachment);
        if (b){
            return "redirect:/project-file.jsp";
        }else {
            return "error";
        }

    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> download(int id) throws IOException {

        //获取下载路径
//        Jedis jedis = jedisPool.getResource();
//        String filePath = jedis.get(id+"");
        String filePath=attachmentService.getPath(id);
        File file = new File(filePath);

        //指定下载文件名称
        String nfile = filePath.substring(filePath.lastIndexOf("\\"),filePath.length());

        HttpHeaders headers = new HttpHeaders();
        //使用硬编码，解决当前的文件名下载中文乱码问题
        String nnfile = new String(nfile.getBytes("UTF-8"),"ISO-8859-1");

        //附件
        headers.setContentDispositionFormData("attachment",nnfile);

        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers,HttpStatus.OK);
    }
}








