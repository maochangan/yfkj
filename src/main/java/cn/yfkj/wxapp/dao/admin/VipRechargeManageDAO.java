package cn.yfkj.wxapp.dao.admin;

import cn.yfkj.wxapp.entity.admin.bo.AnyByIDBO;
import cn.yfkj.wxapp.entity.admin.bo.ManageStatusBO;
import cn.yfkj.wxapp.entity.admin.bo.VipManageAddBO;
import cn.yfkj.wxapp.entity.admin.bo.VipManageUpdateBO;
import cn.yfkj.wxapp.entity.admin.dto.VipManageDTO;

import java.util.List;

public interface VipRechargeManageDAO {

    public List<VipManageDTO> getVipList();

    public VipManageDTO getVipInfo(AnyByIDBO id);

    public int setStatus(ManageStatusBO status);

    public int updateInfo(VipManageUpdateBO info);

    public int addInfo(VipManageAddBO info);
}
