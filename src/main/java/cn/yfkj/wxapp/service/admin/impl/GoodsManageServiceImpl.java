package cn.yfkj.wxapp.service.admin.impl;

import cn.yfkj.wxapp.dao.admin.GoodsManageDAO;
import cn.yfkj.wxapp.entity.admin.bo.*;
import cn.yfkj.wxapp.entity.admin.dto.GoodsInfoManageDTO;
import cn.yfkj.wxapp.service.admin.GoodsManageService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import sun.rmi.runtime.Log;

import java.util.List;

import static cn.yfkj.wxapp.utils.project.WxAuthUtil.ZERO;

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

    @Override
    public SerResult<GoodsInfoManageDTO> getGoodsInfo(AnyByIDBO id) {
        try {
            GoodsInfoManageDTO result = goodsManageDAO.getGoodsInfo(id);
            if (null == result) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }

        } catch (Exception e) {
            logger.error("获取详细信息异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> setGoodsStatus(ManageStatusBO status) {
        try {
            int result = goodsManageDAO.setGoodsStatus(status);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("修改状态异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> updateGoodsInfo(ManageGoodsUpdateBO goodInfo) {
        try {
            int result = goodsManageDAO.updateGoodsInfo(goodInfo);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("修改信息异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> addGoodInfo(ManageGoodsAddBO good) {
        try {
            int result = goodsManageDAO.addGoodInfo(good);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("添加信息异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }
}
