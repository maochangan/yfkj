package cn.yfkj.wxapp.dao.admin;

import cn.yfkj.wxapp.entity.admin.bo.AnyByIDBO;
import cn.yfkj.wxapp.entity.admin.bo.SliderManageAddBO;
import cn.yfkj.wxapp.entity.admin.bo.ManageStatusBO;
import cn.yfkj.wxapp.entity.admin.bo.SliderManageUpdateBO;
import cn.yfkj.wxapp.entity.admin.dto.SliderManageDTO;
import cn.yfkj.wxapp.entity.bo.PageHelperBO;

import java.util.List;

public interface SliderManagerDAO {

    public int getTotalSize(PageHelperBO pageHelper);

    public List<SliderManageDTO> getSliderList(PageHelperBO pageHelper);

    public SliderManageDTO getSliderInfo(AnyByIDBO id);

    public int addSlider(SliderManageAddBO slider);

    public int setSliderStatus(ManageStatusBO status);

    public int updateSliderInfo(SliderManageUpdateBO slider);
}
