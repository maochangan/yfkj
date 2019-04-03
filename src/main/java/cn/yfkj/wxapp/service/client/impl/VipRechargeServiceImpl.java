package cn.yfkj.wxapp.service.client.impl;

import cn.yfkj.wxapp.dao.client.VipRechargeDAO;
import cn.yfkj.wxapp.entity.client.dto.VipDTO;
import cn.yfkj.wxapp.service.client.VipRechargeService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class VipRechargeServiceImpl implements VipRechargeService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VipRechargeDAO vipRechargeDAO;


    @Override
    public SerResult<List<VipDTO>> getVipList() {
        try {
            List<VipDTO> result = vipRechargeDAO.getVipList();
            if (result.isEmpty()) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取VIP列表异常：" + e.getMessage());
            return SerResult.createError();
        }
    }
}
