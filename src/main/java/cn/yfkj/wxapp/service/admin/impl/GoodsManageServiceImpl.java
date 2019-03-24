package cn.yfkj.wxapp.service.admin.impl;

import cn.yfkj.wxapp.dao.admin.GoodsManageDAO;
import cn.yfkj.wxapp.entity.admin.bo.GoodManagePageBO;
import cn.yfkj.wxapp.entity.admin.dto.GoodsInfoManageDTO;
import cn.yfkj.wxapp.service.admin.GoodsManageService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class GoodsManageServiceImpl implements GoodsManageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodsManageDAO goodsManageDAO;


    @Override
    public SerResult<Integer> getTotal(GoodManagePageBO page) {
        try {
            int result = goodsManageDAO.getTotalSize(page);
            return SerResult.createSuccess(result);
        } catch (Exception e) {
            logger.error("获取总数信息异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<List<GoodsInfoManageDTO>> getGoodsInfoList(GoodManagePageBO page) {
        try {
            List<GoodsInfoManageDTO> result = goodsManageDAO.getGoodsInfoList(page);
            if (result.isEmpty()) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取产品信息列表异常:" + e.getMessage());
            return SerResult.createError();
        }
    }
}
