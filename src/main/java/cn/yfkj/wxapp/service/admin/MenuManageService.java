package cn.yfkj.wxapp.service.admin;

import cn.yfkj.wxapp.entity.admin.bo.MenuPageHelperBO;
import cn.yfkj.wxapp.entity.admin.dto.MenuManageDTO;
import cn.yfkj.wxapp.utils.project.SerResult;

import java.util.List;

public interface MenuManageService {


    public SerResult<Integer> getTotalsSize(MenuPageHelperBO page);


    public SerResult<List<MenuManageDTO>> getMenuList(MenuPageHelperBO page);
}
