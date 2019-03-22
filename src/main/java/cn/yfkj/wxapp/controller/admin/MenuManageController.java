package cn.yfkj.wxapp.controller.admin;

import cn.yfkj.wxapp.entity.admin.bo.MenuPageHelperBO;
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


}
