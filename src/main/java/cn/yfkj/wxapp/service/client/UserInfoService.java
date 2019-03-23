package cn.yfkj.wxapp.service.client;

import cn.yfkj.wxapp.entity.client.bo.UserInfoUpdateOrAddBO;
import cn.yfkj.wxapp.entity.client.dto.UserInfoDTO;
import cn.yfkj.wxapp.utils.project.SerResult;

public interface UserInfoService {


    public SerResult<UserInfoDTO> getUserInfo(UserInfoUpdateOrAddBO userInfo);


    public SerResult<Boolean> addUserInfo(UserInfoUpdateOrAddBO userInfo);

    public SerResult<Boolean> updateUserInfo(UserInfoDTO value);
}

