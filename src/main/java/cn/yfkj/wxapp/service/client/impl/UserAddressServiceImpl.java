package cn.yfkj.wxapp.service.client.impl;

import cn.yfkj.wxapp.dao.client.UserAddressDAO;
import cn.yfkj.wxapp.entity.client.bo.UserAddressAddBO;
import cn.yfkj.wxapp.entity.client.bo.UserAddressUpdateBO;
import cn.yfkj.wxapp.entity.client.bo.UserBO;
import cn.yfkj.wxapp.entity.client.dto.UserAddressDTO;
import cn.yfkj.wxapp.service.client.UserAddressService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

import static cn.yfkj.wxapp.utils.project.WxAuthUtil.ZERO;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserAddressServiceImpl implements UserAddressService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserAddressDAO userAddressDAO;


    @Override
    public SerResult<List<UserAddressDTO>> getList(UserBO user) {
        try {
            List<UserAddressDTO> result = userAddressDAO.getList(user);
            if (result.isEmpty()) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取列表异常" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> addAddress(UserAddressAddBO address) {
        try {
            int result = userAddressDAO.addAddress(address);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("添加地址异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> updateAddress(UserAddressUpdateBO userAddress) {
        try {
            int result = userAddressDAO.updateAddress(userAddress);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("修改信息异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }
}
