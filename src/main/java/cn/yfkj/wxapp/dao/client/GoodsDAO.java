package cn.yfkj.wxapp.dao.client;

import cn.yfkj.wxapp.entity.client.bo.GoodsConditionBO;
import cn.yfkj.wxapp.entity.client.dto.GoodsInfoDTO;

import java.util.List;

public interface GoodsDAO {

    public List<GoodsInfoDTO> getGoodsList(GoodsConditionBO condition);
}
