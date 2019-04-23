package cn.yfkj.wxapp.controller.client;

import cn.yfkj.wxapp.entity.client.bo.UserAddressAddBO;
import cn.yfkj.wxapp.entity.client.bo.UserAddressUpdateBO;
import cn.yfkj.wxapp.entity.client.bo.UserBO;
import cn.yfkj.wxapp.entity.client.dto.UserAddressDTO;
import cn.yfkj.wxapp.service.client.UserAddressService;
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

@Api(value = "客户端用户地址管理api")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping(value = "address")
public class UserAddressController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserAddressService userAddressService;

    @ApiOperation(value = "获取地址列表")
    @PostMapping(value = "addressList")
    public ResultMap getAddressList(@RequestBody @Validated @ModelAttribute("user")UserBO user){
        try {
            SerResult<List<UserAddressDTO>> result = userAddressService.getList(user);
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


    @ApiOperation(value = "修改地址详情")
    @PostMapping(value = "updateAddress")
    public ResultMap updateAddress(@RequestBody @Validated @ModelAttribute("userAddress") UserAddressUpdateBO userAddress){
        try {
            SerResult<Boolean> result = userAddressService.updateAddress(userAddress);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("修改异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiOperation(value = "添加地址")
    @PostMapping(value = "addAddress")
    public ResultMap addAddress(@RequestBody @Validated @ModelAttribute("address") UserAddressAddBO address) {
        try {
            SerResult<Boolean> result = userAddressService.addAddress(address);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("添加地址异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }




}
