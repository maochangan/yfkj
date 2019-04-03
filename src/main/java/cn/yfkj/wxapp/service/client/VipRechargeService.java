package cn.yfkj.wxapp.service.client;

import cn.yfkj.wxapp.entity.client.dto.VipDTO;
import cn.yfkj.wxapp.utils.project.SerResult;

import java.util.List;

public interface VipRechargeService {

    public SerResult<List<VipDTO>> getVipList();
}
