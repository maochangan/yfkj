package cn.yfkj.wxapp.dao.client;

import cn.yfkj.wxapp.entity.client.bo.UserInfoUpdateOrAddBO;
import cn.yfkj.wxapp.entity.client.dto.UserInfoDTO;

public interface UserInfoDAO {


    public UserInfoDTO getUserInfo(UserInfoUpdateOrAddBO userInfo);


    public int addUserInfo(UserInfoUpdateOrAddBO userInfo);

    public int updateUserInfo(UserInfoDTO value);
}
