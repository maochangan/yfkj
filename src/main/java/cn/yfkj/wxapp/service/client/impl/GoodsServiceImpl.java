package cn.yfkj.wxapp.service.client.impl;

import cn.yfkj.wxapp.dao.client.GoodsDAO;
import cn.yfkj.wxapp.entity.client.bo.GoodsConditionBO;
import cn.yfkj.wxapp.entity.client.dto.GoodsInfoDTO;
import cn.yfkj.wxapp.service.client.GoodsService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class GoodsServiceImpl implements GoodsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodsDAO goodsDAO;

    @Override
    public SerResult<List<GoodsInfoDTO>> getGoodsList(GoodsConditionBO condition) {
        try {
            List<GoodsInfoDTO> result = goodsDAO.getGoodsList(condition);
            if (result.isEmpty()) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取产品信息异常：" + e.getMessage());
            return SerResult.createError();
        }
    }
}
