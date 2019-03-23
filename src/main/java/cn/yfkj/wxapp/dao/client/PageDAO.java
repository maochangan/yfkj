package cn.yfkj.wxapp.dao.client;

import cn.yfkj.wxapp.entity.admin.bo.UserInfoBO;
import cn.yfkj.wxapp.entity.client.bo.SliderTypeBO;
import cn.yfkj.wxapp.entity.client.dto.MenuDTO;
import cn.yfkj.wxapp.entity.client.dto.SliderDTO;

import java.util.List;

public interface PageDAO {

    public List<SliderDTO> getSliderList(SliderTypeBO sliderType);

    public List<MenuDTO> getMenuList(UserInfoBO user);
}
