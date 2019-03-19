package cn.yfkj.wxapp.service.admin.impl;

import cn.yfkj.wxapp.dao.admin.AdminDAO;
import cn.yfkj.wxapp.entity.bo.AdminUser;
import cn.yfkj.wxapp.service.admin.AdminService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.yfkj.wxapp.utils.project.SerResultCode.ADMIN_LOIGN;

/***
 * 管理员服务层
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class AdminServiceImpl implements AdminService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private AdminDAO adminDAO;


    @Override
    public SerResult<Boolean> adminUserLoginFun(AdminUser adminUser) {
        try {
            int result = adminDAO.adminLoginFun(adminUser);
            if (result == 0) {
                return SerResult.createFail(ADMIN_LOIGN);
            }else{
                return SerResult.createSuccess(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户登录异常" + e.getMessage());
            return SerResult.createError();
        }
    }
}
