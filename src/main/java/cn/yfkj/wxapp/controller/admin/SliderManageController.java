package cn.yfkj.wxapp.controller.admin;

import cn.yfkj.wxapp.entity.admin.dto.SliderManageDTO;
import cn.yfkj.wxapp.entity.bo.PageHelperBO;
import cn.yfkj.wxapp.service.admin.SliderManagerService;
import cn.yfkj.wxapp.utils.project.ResultMap;
import cn.yfkj.wxapp.utils.project.SerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "管理端轮播设置api")
@CrossOrigin(origins = "*" , maxAge = 3600 , allowCredentials = "true")
@RestController
@RequestMapping(value = "slider")
public class SliderManageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SliderManagerService sliderManagerService;

    @ApiOperation(value = "获取轮播图列表")
    @PostMapping(value = "sliderList")
    public ResultMap getSliderList(@RequestBody @Validated @ModelAttribute("pageHelper") PageHelperBO pageHelper){
        try {
            SerResult<Integer> total = sliderManagerService.getTotalSize(pageHelper);
            SerResult<List<SliderManageDTO>> result = sliderManagerService.getSliderList(pageHelper);
            if(result.isSuccess()){
                return ResultMap.createMap("fail" , 0).addDate("没有图片数据");
            }else{
                Map<String , Object> map = new HashMap<>();
                map.put("total" , total.getValue());
                map.put("list" , result.getValue());
                return ResultMap.createMap("success" , 1).addDate(map);
            }
        }catch (Exception e){
            logger.error("获取轮播列表异常："+ e.getMessage());
            return ResultMap.createMap("err" , -1);
        }
    }



}
