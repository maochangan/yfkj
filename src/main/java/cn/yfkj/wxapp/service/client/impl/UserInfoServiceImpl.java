package cn.yfkj.wxapp.service.client.impl;

import cn.yfkj.wxapp.dao.client.UserInfoDAO;
import cn.yfkj.wxapp.entity.client.bo.UserInfoUpdateOrAddBO;
import cn.yfkj.wxapp.entity.client.dto.UserInfoDTO;
import cn.yfkj.wxapp.service.client.UserInfoService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.yfkj.wxapp.utils.project.WxAuthUtil.ZERO;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserInfoServiceImpl implements UserInfoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoDAO userInfoDAO;


    @Override
    public SerResult<UserInfoDTO> getUserInfo(UserInfoUpdateOrAddBO userInfo) {
        try {
            UserInfoDTO result = userInfoDAO.getUserInfo(userInfo);
            if (null == result) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取用户信息异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> addUserInfo(UserInfoUpdateOrAddBO userInfo) {
        try {
            int result = userInfoDAO.addUserInfo(userInfo);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("添加用户信息异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> updateUserInfo(UserInfoDTO value) {
        try {
            int result = userInfoDAO.updateUserInfo(value);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("更新用户信息异常：" + e.getMessage());
            return SerResult.createError();
        }
    }
}
