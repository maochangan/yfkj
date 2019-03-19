package cn.yfkj.wxapp.service.admin;

import cn.yfkj.wxapp.entity.admin.dto.SliderManageDTO;
import cn.yfkj.wxapp.entity.bo.PageHelperBO;
import cn.yfkj.wxapp.utils.project.SerResult;

import java.util.List;

public interface SliderManagerService {

    public SerResult<Integer> getTotalSize(PageHelperBO pageHelper);


    public SerResult<List<SliderManageDTO>> getSliderList(PageHelperBO pageHelper);
}
