package cn.yfkj.wxapp.service.client.impl;

import cn.yfkj.wxapp.dao.client.PageDAO;
import cn.yfkj.wxapp.entity.admin.bo.UserInfoBO;
import cn.yfkj.wxapp.entity.client.bo.SliderTypeBO;
import cn.yfkj.wxapp.entity.client.dto.MenuDTO;
import cn.yfkj.wxapp.entity.client.dto.SliderDTO;
import cn.yfkj.wxapp.service.client.PageService;
import cn.yfkj.wxapp.utils.project.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class PageServiceImpl implements PageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PageDAO pageDAO;


    @Override
    public SerResult<List<SliderDTO>> getSliderList(SliderTypeBO sliderType) {
        try {
            List<SliderDTO> result = pageDAO.getSliderList(sliderType);
            if (result.isEmpty()) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取轮播图片列表异常：" + e.getMessage());
            return SerResult.createError();
        }
    }

    @Override
    public SerResult<List<MenuDTO>> getMenuList(UserInfoBO user) {
        try {
            List<MenuDTO> result = pageDAO.getMenuList(user);
            if (result.isEmpty()) {
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("获取菜单列表异常：" + e.getMessage());
            return SerResult.createError();
        }
    }
}
