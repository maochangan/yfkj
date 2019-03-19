package cn.yfkj.wxapp.service.admin.impl;

import cn.yfkj.wxapp.dao.admin.SliderManagerDAO;
import cn.yfkj.wxapp.entity.admin.dto.SliderManageDTO;
import cn.yfkj.wxapp.entity.bo.PageHelperBO;
import cn.yfkj.wxapp.service.admin.SliderManagerService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return null;
    }
}
