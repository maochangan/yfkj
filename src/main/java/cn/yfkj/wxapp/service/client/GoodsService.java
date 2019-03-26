package cn.yfkj.wxapp.service.client;

import cn.yfkj.wxapp.entity.client.bo.GoodsConditionBO;
import cn.yfkj.wxapp.entity.client.dto.GoodsInfoDTO;
import cn.yfkj.wxapp.utils.project.SerResult;

import java.util.List;

public interface GoodsService {

    public SerResult<List<GoodsInfoDTO>> getGoodsList(GoodsConditionBO condition);
}
