package cn.yfkj.wxapp.controller.admin;


import cn.yfkj.wxapp.entity.bo.AdminUser;
import cn.yfkj.wxapp.service.admin.AdminService;
import cn.yfkj.wxapp.utils.project.ResultMap;
import cn.yfkj.wxapp.utils.project.SerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(value = "管理员用户登录")
@CrossOrigin(origins = "*" , maxAge = 3600 , allowCredentials = "true")
@RestController
@RequestMapping(value = "admin")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private AdminService adminService;


    @ApiOperation(value = "管理员用户登录接口")
    @PostMapping(value = "adminLogin")
    public ResultMap adminLogin(@RequestBody @Validated @ModelAttribute("adminUser") AdminUser adminUser){
        try {
            SerResult<Boolean> result = adminService.adminUserLoginFun(adminUser);
            if (result.isSuccess()) {
                return ResultMap.createMap("success", 1).addDate("用户登录成功");
            }else{
                return ResultMap.createMap("fail", 0).addDate("用户登录失败");
            }
        } catch (Exception e) {
            logger.error("用户登录异常:" + e.getMessage());
            return ResultMap.createMap("err", -1).addDate("system error");
        }
    }




}
