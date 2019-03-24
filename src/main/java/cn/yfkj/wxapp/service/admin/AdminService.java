package cn.yfkj.wxapp.service.admin;

import cn.yfkj.wxapp.entity.admin.bo.AdminUser;
import cn.yfkj.wxapp.utils.project.SerResult;

public interface AdminService {

    SerResult<Boolean> adminUserLoginFun(AdminUser adminUser);
}
