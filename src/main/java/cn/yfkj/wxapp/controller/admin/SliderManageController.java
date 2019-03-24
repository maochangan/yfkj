package cn.yfkj.wxapp.controller.admin;

import cn.yfkj.wxapp.entity.admin.bo.AnyByIDBO;
import cn.yfkj.wxapp.entity.admin.bo.SliderManageAddBO;
import cn.yfkj.wxapp.entity.admin.bo.ManageStatusBO;
import cn.yfkj.wxapp.entity.admin.bo.SliderManageUpdateBO;
import cn.yfkj.wxapp.entity.admin.dto.SliderManageDTO;
import cn.yfkj.wxapp.entity.admin.bo.PageHelperBO;
import cn.yfkj.wxapp.service.admin.SliderManagerService;
import cn.yfkj.wxapp.utils.project.ResultMap;
import cn.yfkj.wxapp.utils.project.SerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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
                Map<String , Object> map = new HashMap<>();
                map.put("total" , total.getValue());
                map.put("list" , result.getValue());
                return ResultMap.createMap("success" , 1).addDate(map);
            }else{
                return ResultMap.createMap("fail" , 0).addDate("没有图片数据");
            }
        }catch (Exception e){
            logger.error("获取轮播列表异常："+ e.getMessage());
            return ResultMap.createMap("err" , -1);
        }
    }

    @ApiOperation(value = "获取轮播图详情")
    @PostMapping(value = "sliderInfo")
    public ResultMap getSliderInfo(@RequestBody @Validated @ModelAttribute("ID") AnyByIDBO ID){
        try {
            SerResult<SliderManageDTO> result = sliderManagerService.getSliderInfo(ID);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1).addDate(result);
            }else{
                return ResultMap.createMap("fail", 0);
            }

        } catch (Exception e) {
            logger.error("获取轮播图详情异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiOperation(value = "添加轮播图")
    @PostMapping(value = "addSlider")
    public ResultMap addSlider(@RequestBody @Validated @ModelAttribute("slider") SliderManageAddBO slider){
        try {
            SerResult<Boolean> result = sliderManagerService.addSlider(slider);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("添加轮播图信息异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }


    @ApiOperation(value = "删除 修改轮播状态")
    @PostMapping(value = "sliderStatus")
    public ResultMap setSliderStatus(@RequestBody @Validated @ModelAttribute("status") ManageStatusBO status){
        try {
            SerResult<Boolean> result = sliderManagerService.setSliderStatus(status);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fail", 0);
            }

        } catch (Exception e) {
            logger.error("修改状态异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiModelProperty(value = "修改轮播信息")
    @PostMapping(value = "sliderUpdate")
    public ResultMap updateSliderInfo(@RequestBody @Validated @ModelAttribute("slider") SliderManageUpdateBO slider){
        try {
            SerResult<Boolean> result = sliderManagerService.updateSliderInfo(slider);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("update slider err" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }




}
