package cn.yfkj.wxapp.controller.admin;

import cn.yfkj.wxapp.entity.admin.bo.*;
import cn.yfkj.wxapp.entity.admin.dto.MenuManageDTO;
import cn.yfkj.wxapp.entity.bo.PageHelperBO;
import cn.yfkj.wxapp.service.admin.MenuManageService;
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

@Api(value = "菜单管理api")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping(value = "menuManage")
public class MenuManageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuManageService manageService;


    @ApiOperation(value = "获取菜单列表")
    @PostMapping(value = "menuList")
    public ResultMap getMenuList(@RequestBody @Validated @ModelAttribute("page") MenuPageHelperBO page) {
        try {
            SerResult<Integer> total = manageService.getTotalsSize(page);
            SerResult<List<MenuManageDTO>> result = manageService.getMenuList(page);
            if (result.isSuccess()) {
                Map<String, Object> map = new HashMap<>();
                map.put("total", total.getValue());
                map.put("list", result.getValue());
                return ResultMap.createMap("success", 1).addDate(map);
            }else{
                return ResultMap.createMap("fail", 0);
            }
         } catch (Exception e) {
            logger.error("获取菜单列表异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }


    @ApiOperation(value = "获取菜单详情")
    @PostMapping(value = "menuInfo")
    public ResultMap getMenuInfo(@RequestBody @Validated @ModelAttribute("ID")AnyByIDBO ID) {
        try {
            SerResult<MenuManageDTO> result = manageService.getMenuInfo(ID);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1).addDate(result);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("获取菜单详情异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiOperation(value = "修改菜单状态")
    @PostMapping(value = "menuStatus")
    public ResultMap setMenuStatus(@RequestBody @Validated @ModelAttribute("status")ManageStatusBO status){
        try {
            SerResult<Boolean> result = manageService.setMenuStatus(status);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("修改状态异常:" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiOperation(value = "添加菜单")
    @PostMapping(value = "addMenu")
    public ResultMap addMenu(@RequestBody @Validated @ModelAttribute("menu") MenuManageAddBO menu) {
        try {
            SerResult<Boolean> result = manageService.addMenu(menu);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("添加菜单异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiOperation(value = "修改菜单信息")
    @PostMapping(value = "updateMenu")
    public ResultMap updateMenu(@RequestBody @Validated @ModelAttribute("menu") MenuManageUpdateBO menu){
        try {
            SerResult<Boolean> result = manageService.updateMenu(menu);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fial", 0);
            }
        } catch (Exception e) {
            logger.error("修改菜单信息异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }


}
