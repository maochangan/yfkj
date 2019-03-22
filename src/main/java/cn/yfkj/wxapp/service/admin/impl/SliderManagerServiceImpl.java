package cn.yfkj.wxapp.service.admin.impl;

import cn.yfkj.wxapp.dao.admin.SliderManagerDAO;
import cn.yfkj.wxapp.entity.admin.bo.AnyByIDBO;
import cn.yfkj.wxapp.entity.admin.bo.SliderManageAddBO;
import cn.yfkj.wxapp.entity.admin.bo.ManageStatusBO;
import cn.yfkj.wxapp.entity.admin.bo.SliderManageUpdateBO;
import cn.yfkj.wxapp.entity.admin.dto.SliderManageDTO;
import cn.yfkj.wxapp.entity.bo.PageHelperBO;
import cn.yfkj.wxapp.service.admin.SliderManagerService;
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
public class SliderManagerServiceImpl implements SliderManagerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SliderManagerDAO sliderManagerDAO;


    @Override
    public SerResult<Integer> getTotalSize(PageHelperBO pageHelper) {
        try {
            int result = sliderManagerDAO.getTotalSize(pageHelper);
            return SerResult.createSuccess(result);
        }catch (Exception e){
            logger.error("获取轮播总数异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<List<SliderManageDTO>> getSliderList(PageHelperBO pageHelper) {
        try {
            List<SliderManageDTO> result = sliderManagerDAO.getSliderList(pageHelper);
            if (result.isEmpty()) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取轮播列表异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<SliderManageDTO> getSliderInfo(AnyByIDBO id) {
        try {
            SliderManageDTO result = sliderManagerDAO.getSliderInfo(id);
            if (null == result) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取轮播详情异常:" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> addSlider(SliderManageAddBO slider) {
        try {
            int result = sliderManagerDAO.addSlider(slider);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("添加轮播异常：" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> setSliderStatus(ManageStatusBO status) {
        try {
            int result = sliderManagerDAO.setSliderStatus(status);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("set status err" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<Boolean> updateSliderInfo(SliderManageUpdateBO slider) {
        try {
            int result = sliderManagerDAO.updateSliderInfo(slider);
            if (ZERO.equals(result)) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(true);
            }
        } catch (Exception e) {
            logger.error("update slider err" + e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();
            return SerResult.createError();
        }
    }
}
