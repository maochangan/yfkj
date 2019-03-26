package cn.yfkj.wxapp.controller.admin;

import cn.yfkj.wxapp.entity.admin.bo.*;
import cn.yfkj.wxapp.entity.admin.dto.GoodsInfoManageDTO;
import cn.yfkj.wxapp.service.admin.GoodsManageService;
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

@Api(value = "产品管理api")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping(value = "goodManage")
public class GoodesManageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodsManageService goodsManageService;


    @ApiOperation(value = "获取产品列表")
    @PostMapping(value = "goodsList")
    public ResultMap getGoodsList(@RequestBody @Validated @ModelAttribute("page") GoodManagePageBO page){
        try {
            SerResult<Integer> total = goodsManageService.getTotal(page);
            SerResult<List<GoodsInfoManageDTO>> result = goodsManageService.getGoodsInfoList(page);
            if (result.isSuccess()) {
                Map<String, Object> map = new HashMap<>();
                map.put("total", total.getValue());
                map.put("list", result.getValue());
                return ResultMap.createMap("success", 1).addDate(map);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("获取产品列表异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }


    @ApiOperation(value = "获取产品信息")
    @PostMapping(value = "goodsInfo")
    public ResultMap getGoodInfo(@RequestBody @Validated @ModelAttribute("ID") AnyByIDBO ID) {
        try {
            SerResult<GoodsInfoManageDTO> result = goodsManageService.getGoodsInfo(ID);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1).addDate(result.getValue());
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("获取详细信息异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }


    @ApiOperation(value = "修改产品状态")
    @PostMapping(value = "goodStatus")
    public ResultMap setGoodsStatus(@RequestBody @Validated @ModelAttribute("status")ManageStatusBO status){
        try {
            SerResult<Boolean> result = goodsManageService.setGoodsStatus(status);
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

    @ApiOperation(value = "添加产品信息")
    @PostMapping(value = "updateGoods")
    public ResultMap updateGoodsInfo(@RequestBody @Validated @ModelAttribute("goodInfo") ManageGoodsUpdateBO goodInfo){
        try {
            SerResult<Boolean> result = goodsManageService.updateGoodsInfo(goodInfo);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("添加产品信息异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiOperation(value = "添加产品信息")
    @PostMapping(value = "addGoodInfo")
    public ResultMap addGoodInfo(@RequestBody @Validated @ModelAttribute("good") ManageGoodsAddBO good){
        try {
            SerResult<Boolean> result = goodsManageService.addGoodInfo(good);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("添加信息异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }






}
