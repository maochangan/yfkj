package cn.yfkj.wxapp.controller.client;

import cn.yfkj.wxapp.entity.client.bo.GoodsConditionBO;
import cn.yfkj.wxapp.entity.client.dto.GoodsInfoDTO;
import cn.yfkj.wxapp.service.client.GoodsService;
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

@Api(value = "客户端产品api")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping(value = "good")
public class GoodsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "获取产品信息")
    @PostMapping(value = "list")
    public ResultMap getGoodsList(@RequestBody @Validated @ModelAttribute("condition") GoodsConditionBO condition) {
        try {
            SerResult<List<GoodsInfoDTO>> result = goodsService.getGoodsList(condition);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1).addDate(result.getValue());
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("获取列表异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

}
