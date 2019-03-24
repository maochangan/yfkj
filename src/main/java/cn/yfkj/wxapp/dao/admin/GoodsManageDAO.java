package cn.yfkj.wxapp.dao.admin;

import cn.yfkj.wxapp.entity.admin.bo.GoodManagePageBO;
import cn.yfkj.wxapp.entity.admin.dto.GoodsInfoManageDTO;

import java.util.List;

public interface GoodsManageDAO {

    public int getTotalSize(GoodManagePageBO page);


    public List<GoodsInfoManageDTO> getGoodsInfoList(GoodManagePageBO page);
}
