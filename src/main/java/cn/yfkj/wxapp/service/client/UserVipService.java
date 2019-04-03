package cn.yfkj.wxapp.service.client;

import cn.yfkj.wxapp.entity.client.bo.UserBO;
import cn.yfkj.wxapp.entity.client.bo.UserBuyInfo;
import cn.yfkj.wxapp.entity.client.dto.UserVipDTO;
import cn.yfkj.wxapp.utils.project.SerResult;

import java.util.Map;

public interface UserVipService {

    public SerResult<UserVipDTO> getVipInfo(UserBO user);

    public SerResult<Boolean> createVip(UserBO user);

    public SerResult<Map<String, Object>> userPay(UserBuyInfo info);
}
