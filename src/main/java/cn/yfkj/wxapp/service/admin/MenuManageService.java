package cn.yfkj.wxapp.service.admin;

import cn.yfkj.wxapp.entity.admin.bo.*;
import cn.yfkj.wxapp.entity.admin.dto.MenuManageDTO;
import cn.yfkj.wxapp.utils.project.SerResult;

import java.util.List;

public interface MenuManageService {


    public SerResult<Integer> getTotalsSize(MenuPageHelperBO page);


    public SerResult<List<MenuManageDTO>> getMenuList(MenuPageHelperBO page);

    public SerResult<MenuManageDTO> getMenuInfo(AnyByIDBO id);

    public SerResult<Boolean> setMenuStatus(ManageStatusBO status);

    public SerResult<Boolean> addMenu(MenuManageAddBO menu);

    public SerResult<Boolean> updateMenu(MenuManageUpdateBO menu);
}
