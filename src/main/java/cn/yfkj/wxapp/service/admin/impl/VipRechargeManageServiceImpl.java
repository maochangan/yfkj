package cn.yfkj.wxapp.service.admin.impl;

import cn.yfkj.wxapp.dao.admin.VipRechargeManageDAO;
import cn.yfkj.wxapp.entity.admin.bo.AnyByIDBO;
import cn.yfkj.wxapp.entity.admin.bo.ManageStatusBO;
import cn.yfkj.wxapp.entity.admin.bo.VipManageAddBO;
import cn.yfkj.wxapp.entity.admin.bo.VipManageUpdateBO;
import cn.yfkj.wxapp.entity.admin.dto.VipManageDTO;
import cn.yfkj.wxapp.service.admin.VipRechargeManageService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

import static cn.yfkj.wxapp.utils.project.WxAuthUtil.ZERO;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class VipRechargeManageServiceImpl implements VipRechargeManageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VipRechargeManageDAO vipRechargeManageDAO;


    @Override
    public SerResult<List<VipManageDTO>> getVipList() {
        try {
            List<VipManageDTO> result = vipRechargeManageDAO.getVipList();
            if (result.isEmpty()) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取列表异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<VipManageDTO> getVipInfo(AnyByIDBO id) {
        try {
            VipManageDTO result = vipRechargeManageDAO.getVipInfo(id);
            if (null == result) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取详情异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> setVipStatus(ManageStatusBO status) {
        try {
            int result = vipRechargeManageDAO.setStatus(status);
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
    public SerResult<Boolean> updateInfo(VipManageUpdateBO info) {
        try {
            int result = vipRechargeManageDAO.updateInfo(info);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("修改异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createFail();
        }
    }

    @Override
    public SerResult<Boolean> addInfo(VipManageAddBO info) {
        try {
            int result = vipRechargeManageDAO.addInfo(info);
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
