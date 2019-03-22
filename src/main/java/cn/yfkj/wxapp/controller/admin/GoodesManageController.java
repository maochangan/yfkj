package cn.yfkj.wxapp.controller.admin;

import cn.yfkj.wxapp.utils.project.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "产品管理api")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping(value = "goodManage")
public class GoodesManageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "获取产品列表")
    @PostMapping(value = "goodsList")
    public ResultMap getGoodsList(){
        return null;
    }


}
