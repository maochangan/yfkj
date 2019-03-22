package cn.yfkj.wxapp.service.admin.impl;

import cn.yfkj.wxapp.dao.admin.MenuManageDAO;
import cn.yfkj.wxapp.entity.admin.bo.*;
import cn.yfkj.wxapp.entity.admin.dto.MenuManageDTO;
import cn.yfkj.wxapp.service.admin.MenuManageService;
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
public class MenuManageServiceImpl implements MenuManageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuManageDAO manageDAO;

    @Override
    public SerResult<Integer> getTotalsSize(MenuPageHelperBO page) {
        try {
            int result = manageDAO.getTotalSize(page);
            return SerResult.createSuccess(result);
        } catch (Exception e) {
            logger.error("获取菜单列表总数异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<List<MenuManageDTO>> getMenuList(MenuPageHelperBO page) {
        try {
            List<MenuManageDTO> result = manageDAO.getMenuList(page);
            if (result.isEmpty()) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取菜单列表异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<MenuManageDTO> getMenuInfo(AnyByIDBO id) {
        try {
            MenuManageDTO result = manageDAO.getMenuInfo(id);
            if (null == result) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取菜单详情异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> setMenuStatus(ManageStatusBO status) {
        try {
            int result = manageDAO.setMenuStatus(status);
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
    public SerResult<Boolean> addMenu(MenuManageAddBO menu) {
        try {
            int result = manageDAO.addMenu(menu);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("添加菜单异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> updateMenu(MenuManageUpdateBO menu) {
        try {
            int result = manageDAO.updateMenu(menu);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("修改菜单信息异常;" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }
}
