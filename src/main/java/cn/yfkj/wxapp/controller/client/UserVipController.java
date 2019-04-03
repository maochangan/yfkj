package cn.yfkj.wxapp.controller.client;

import cn.yfkj.wxapp.entity.client.bo.UserBO;
import cn.yfkj.wxapp.entity.client.bo.UserBuyInfo;
import cn.yfkj.wxapp.entity.client.dto.UserVipDTO;
import cn.yfkj.wxapp.service.client.UserVipService;
import cn.yfkj.wxapp.utils.project.ResultMap;
import cn.yfkj.wxapp.utils.project.SerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "客户端vip api")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping(value = "vip")
public class UserVipController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserVipService userVipService;


    @ApiOperation(value = "获取用户的积分信息")
    @PostMapping(value = "vipInfo")
    public ResultMap geVipInfo(@RequestBody @Validated @ModelAttribute("user") UserBO user){
        try {
            SerResult<UserVipDTO> result = userVipService.getVipInfo(user);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1).addDate(result.getValue());
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("获取积分异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiOperation(value = "创建VIP")
    @PostMapping(value = "createVip")
    public ResultMap createVip(@RequestBody @Validated @ModelAttribute("user")UserBO user){
        try {
            SerResult<Boolean> result = userVipService.createVip(user);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fial", 0);
            }
        } catch (Exception e) {
            logger.error("创建VIP异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiOperation(value = "用户购买")
    @PostMapping(value = "pay")
    public ResultMap userPay(@RequestBody @Validated @ModelAttribute("info") UserBuyInfo info) {
        try {
            SerResult<Map<String, Object>> result = userVipService.userPay(info);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1).addDate(result.getValue());
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("用户购买信息异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }



}
