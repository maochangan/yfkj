package cn.yfkj.wxapp.controller.admin;

import cn.yfkj.wxapp.entity.admin.bo.AnyByIDBO;
import cn.yfkj.wxapp.entity.admin.bo.ManageStatusBO;
import cn.yfkj.wxapp.entity.admin.bo.VipManageUpdateBO;
import cn.yfkj.wxapp.entity.admin.dto.VipManageDTO;
import cn.yfkj.wxapp.service.admin.VipRechargeManageService;
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

@Api(value = "会员充值档次api")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping(value = "vipManager")
public class VipRechargeManageControlelr {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VipRechargeManageService vipRechargeManageService;


    @ApiOperation(value = "获取会员充值档次列表")
    @PostMapping(value = "vipManageList")
    public ResultMap getVipManageList(){
        try {
            SerResult<List<VipManageDTO>> result = vipRechargeManageService.getVipList();
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1).addDate(result.getValue());
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("获取列表差异：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiOperation(value = "获取VIP充值档次详情")
    @PostMapping(value = "vipInfo")
    public ResultMap getVipInfo(@RequestBody @Validated @ModelAttribute("ID") AnyByIDBO ID){
        try {
            SerResult<VipManageDTO> result = vipRechargeManageService.getVipInfo(ID);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1).addDate(result.getValue());
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("获取详情异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiOperation(value = "修改状态")
    @PostMapping(value = "vipStatus")
    public ResultMap setVipStatus(@RequestBody @Validated @ModelAttribute("status") ManageStatusBO status){
        try {
            SerResult<Boolean> result = vipRechargeManageService.setVipStatus(status);
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

    @ApiOperation(value = "修改信息")
    @PostMapping(value = " ")
    public ResultMap updateInfo(@RequestBody @Validated @ModelAttribute("info") VipManageUpdateBO info) {
        try {
            SerResult<Boolean> result = vipRechargeManageService.updateInfo(info);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("修改信息异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }





}
