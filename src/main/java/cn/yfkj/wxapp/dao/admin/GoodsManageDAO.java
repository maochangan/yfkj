package cn.yfkj.wxapp.dao.admin;

import cn.yfkj.wxapp.entity.admin.bo.*;
import cn.yfkj.wxapp.entity.admin.dto.GoodsInfoManageDTO;

import java.util.List;

public interface GoodsManageDAO {

    public int getTotalSize(GoodManagePageBO page);


    public List<GoodsInfoManageDTO> getGoodsInfoList(GoodManagePageBO page);

    public GoodsInfoManageDTO getGoodsInfo(AnyByIDBO id);

    public int setGoodsStatus(ManageStatusBO status);

    public int updateGoodsInfo(ManageGoodsUpdateBO goodInfo);

    public int addGoodInfo(ManageGoodsAddBO good);
}
