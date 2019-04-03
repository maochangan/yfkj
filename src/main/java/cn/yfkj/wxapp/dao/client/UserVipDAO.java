package cn.yfkj.wxapp.dao.client;

import cn.yfkj.wxapp.entity.client.bo.UserBO;
import cn.yfkj.wxapp.entity.client.dto.UserVipDTO;

public interface UserVipDAO {

    public UserVipDTO getVipInfo(UserBO user);

    public int createVip(UserBO user);

    public int updateVipInfo(UserVipDTO value);
}
