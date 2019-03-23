package cn.yfkj.wxapp.service.client;

import cn.yfkj.wxapp.entity.admin.bo.UserInfoBO;
import cn.yfkj.wxapp.entity.client.bo.SliderTypeBO;
import cn.yfkj.wxapp.entity.client.dto.MenuDTO;
import cn.yfkj.wxapp.entity.client.dto.SliderDTO;
import cn.yfkj.wxapp.utils.project.SerResult;

import java.util.List;

public interface PageService {


    public SerResult<List<SliderDTO>> getSliderList(SliderTypeBO sliderType);


    public SerResult<List<MenuDTO>> getMenuList(UserInfoBO user);
}
