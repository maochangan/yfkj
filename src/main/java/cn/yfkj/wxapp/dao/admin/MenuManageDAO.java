package cn.yfkj.wxapp.dao.admin;

import cn.yfkj.wxapp.entity.admin.bo.*;
import cn.yfkj.wxapp.entity.admin.dto.MenuManageDTO;

import java.util.List;

public interface MenuManageDAO {

    public int getTotalSize(MenuPageHelperBO page);


    public List<MenuManageDTO> getMenuList(MenuPageHelperBO page);

    public MenuManageDTO getMenuInfo(AnyByIDBO id);

    public int setMenuStatus(ManageStatusBO status);

    public int addMenu(MenuManageAddBO menu);

    public int updateMenu(MenuManageUpdateBO menu);
}
