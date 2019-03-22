package cn.yfkj.wxapp.service.admin.impl;

import cn.yfkj.wxapp.dao.admin.MenuManageDAO;
import cn.yfkj.wxapp.entity.admin.bo.MenuPageHelperBO;
import cn.yfkj.wxapp.entity.admin.dto.MenuManageDTO;
import cn.yfkj.wxapp.service.admin.MenuManageService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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



        } catch (Exception e) {
            logger.error("获取菜单列表异常：" + e.getMessage());

        }
    }
}
