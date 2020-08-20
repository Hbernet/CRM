package com.hb.usual.service;

import com.hb.usual.service.BaoXiaoService;
import com.hb.usual.bean.Baoxiao;
import com.hb.usual.bean.Baoxiaoreply;
import com.hb.usual.mapper.BaoxiaoMapper;
import com.hb.usual.mapper.BaoxiaoreplyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-09 14:53
 */
@Service
public class BaoXiaoServiceImpl implements BaoXiaoService {

    @Resource
    private BaoxiaoMapper baoxiaoMapper;
    @Resource
    private BaoxiaoreplyMapper baoxiaoreplyMapper;

    @Override
    public List<Baoxiao> getAllBaoxiao() {
        return baoxiaoMapper.getAllBaoxiao();
    }

    @Override
    public Baoxiao getOneBaoXiaoByid(String bxid) {
        return baoxiaoMapper.getOneBaoXiaoByid(bxid);
    }

    @Override
    public boolean shenpi(Baoxiao baoxiao, String content) {

        //改变报销状态
        boolean b = baoxiaoMapper.updateByPrimaryKeySelective(baoxiao)>0;

        //创建批注信息对象
        Baoxiaoreply br = new Baoxiaoreply();
        br.setBaoxiaoFk(baoxiao.getBxid());
        br.setContent(content);
        boolean b1 = baoxiaoreplyMapper.insert(br)>0;

        if (b&&b1){
            return true;
        }

        return false;
    }

    @Override
    public List<Baoxiao> getBaoByid(Integer eid) {
        List<Baoxiao> baoxiaos=baoxiaoMapper.getBaoByid(1);
        return baoxiaos;
    }
}
