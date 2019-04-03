package cn.yfkj.wxapp.controller.client;

import cn.yfkj.wxapp.entity.client.dto.VipDTO;
import cn.yfkj.wxapp.service.client.VipRechargeService;
import cn.yfkj.wxapp.utils.project.ResultMap;
import cn.yfkj.wxapp.utils.project.SerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "客户端VIP充值api")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping(value = "recharge")
public class VipRechargeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VipRechargeService vipRechargeService;

    @ApiOperation(value = "获取充值列表")
    @PostMapping(value = "getList")
    public ResultMap getVipList(){
        try {
            SerResult<List<VipDTO>> result = vipRechargeService.getVipList();
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1).addDate(result.getValue());
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("获取充值列表异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }




}
