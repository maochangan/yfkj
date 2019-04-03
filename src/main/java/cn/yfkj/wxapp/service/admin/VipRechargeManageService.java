package cn.yfkj.wxapp.service.admin;

import cn.yfkj.wxapp.entity.admin.bo.AnyByIDBO;
import cn.yfkj.wxapp.entity.admin.bo.ManageStatusBO;
import cn.yfkj.wxapp.entity.admin.bo.VipManageAddBO;
import cn.yfkj.wxapp.entity.admin.bo.VipManageUpdateBO;
import cn.yfkj.wxapp.entity.admin.dto.VipManageDTO;
import cn.yfkj.wxapp.utils.project.SerResult;

import java.util.List;

public interface VipRechargeManageService {

    public SerResult<List<VipManageDTO>> getVipList();

    public SerResult<VipManageDTO> getVipInfo(AnyByIDBO id);

    public SerResult<Boolean> setVipStatus(ManageStatusBO status);

    public SerResult<Boolean> updateInfo(VipManageUpdateBO info);

    public SerResult<Boolean> addInfo(VipManageAddBO info);
}
