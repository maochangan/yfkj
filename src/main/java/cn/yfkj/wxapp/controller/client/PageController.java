package cn.yfkj.wxapp.controller.client;

import cn.yfkj.wxapp.entity.client.bo.SliderTypeBO;
import cn.yfkj.wxapp.entity.client.dto.SliderDTO;
import cn.yfkj.wxapp.service.client.PageService;
import cn.yfkj.wxapp.utils.project.ResultMap;
import cn.yfkj.wxapp.utils.project.SerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "客户端页面api")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping(value = "page")
public class PageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PageService pageService;

    @ApiOperation(value = "获取轮播图片列表信息")
    @PostMapping(value = "slider")
    public ResultMap getSliderList(@RequestBody @Validated @ModelAttribute("sliderType") SliderTypeBO sliderType){
        try {
            SerResult<List<SliderDTO>> result = pageService.getSliderList(sliderType);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1).addDate(result.getValue());
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("获取轮播图片异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }



}
