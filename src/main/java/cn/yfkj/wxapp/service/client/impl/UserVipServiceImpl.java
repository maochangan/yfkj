package cn.yfkj.wxapp.service.client.impl;

import cn.yfkj.wxapp.dao.client.RecordDAO;
import cn.yfkj.wxapp.dao.client.UserVipDAO;
import cn.yfkj.wxapp.entity.client.bo.UserBO;
import cn.yfkj.wxapp.entity.client.bo.UserBuyInfo;
import cn.yfkj.wxapp.entity.client.dto.GoodsInfoDTO;
import cn.yfkj.wxapp.entity.client.dto.UserVipDTO;
import cn.yfkj.wxapp.service.client.UserVipService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

import static cn.yfkj.wxapp.utils.project.WxAuthUtil.ZERO;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserVipServiceImpl implements UserVipService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserVipDAO userVipDAO;

    @Autowired
    private RecordDAO recordDAO;


    @Override
    public SerResult<UserVipDTO> getVipInfo(UserBO user) {
        try {
            UserVipDTO result = userVipDAO.getVipInfo(user);
            if (null == result) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取VIP信息异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> createVip(UserBO user) {
        try {
            UserVipDTO vipInfo = userVipDAO.getVipInfo(user);
            if (null != vipInfo) {
                return SerResult.createSuccess(true);
            }else{
                int result = userVipDAO.createVip(user);
                if (ZERO.equals(result)) {
                    return SerResult.createFail();
                }else{
                    return SerResult.createSuccess(true);
                }
            }
        } catch (Exception e) {
            logger.error("创建会员异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Map<String, Object>> userPay(UserBuyInfo info) {
        try {
            List<GoodsInfoDTO> goodList = info.getGoodsList();
            // 商品总价
            Float total = info.getTotal();
            // 用户id
            String openID = info.getOpenID();
            UserBO userBO = new UserBO();
            userBO.setOpenID(openID);
            SerResult<UserVipDTO> vipInfo = getVipInfo(userBO);
            if (vipInfo.isSuccess()) {
                // 第一步 保存购买记录
                int saveRecord = recordDAO.saveRecord(info);
                if (ZERO.equals(saveRecord)) {
                    return SerResult.createFail();
                }else{
                    // 第三步 扣除余额
                    UserVipDTO value = vipInfo.getValue();
                    value.setVipBalance(value.getVipBalance() - total);
                    value.setVipIntegral((long) (value.getVipIntegral() + (total/10)));
                    // 更新余额数据
                    int updateBalance = userVipDAO.updateVipInfo(value);
                    if (ZERO.equals(updateBalance)) {
                        return SerResult.createFail();
                    }else{
                        // 返回兑换码
                        return SerResult.createSuccess(null);
                    }
                }
            }else{
                return SerResult.createFail();
            }
        } catch (Exception e) {
            logger.error("余额购买异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }
}
