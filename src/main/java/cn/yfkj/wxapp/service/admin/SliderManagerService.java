package cn.yfkj.wxapp.service.admin;

import cn.yfkj.wxapp.entity.admin.bo.AnyByIDBO;
import cn.yfkj.wxapp.entity.admin.bo.SliderManageAddBO;
import cn.yfkj.wxapp.entity.admin.bo.SliderManageStatusBO;
import cn.yfkj.wxapp.entity.admin.bo.SliderManageUpdateBO;
import cn.yfkj.wxapp.entity.admin.dto.SliderManageDTO;
import cn.yfkj.wxapp.entity.bo.PageHelperBO;
import cn.yfkj.wxapp.utils.project.SerResult;

import java.util.List;

public interface SliderManagerService {

    public SerResult<Integer> getTotalSize(PageHelperBO pageHelper);


    public SerResult<List<SliderManageDTO>> getSliderList(PageHelperBO pageHelper);

    public SerResult<SliderManageDTO> getSliderInfo(AnyByIDBO id);

    public SerResult<Boolean> addSlider(SliderManageAddBO slider);

    public SerResult<Boolean> setSliderStatus(SliderManageStatusBO status);

    public SerResult<Boolean> updateSliderInfo(SliderManageUpdateBO slider);
}
