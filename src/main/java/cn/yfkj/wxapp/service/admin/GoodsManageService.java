package cn.yfkj.wxapp.service.admin;

import cn.yfkj.wxapp.entity.admin.bo.*;
import cn.yfkj.wxapp.entity.admin.dto.GoodsInfoManageDTO;
import cn.yfkj.wxapp.utils.project.SerResult;

import java.util.List;

public interface GoodsManageService {


    public SerResult<Integer> getTotal(GoodManagePageBO page);


    public SerResult<List<GoodsInfoManageDTO>> getGoodsInfoList(GoodManagePageBO page);

    public SerResult<GoodsInfoManageDTO> getGoodsInfo(AnyByIDBO id);

    public SerResult<Boolean> setGoodsStatus(ManageStatusBO status);

    public SerResult<Boolean> updateGoodsInfo(ManageGoodsUpdateBO goodInfo);

    public SerResult<Boolean> addGoodInfo(ManageGoodsAddBO good);
}
