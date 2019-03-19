package cn.yfkj.wxapp.controller.admin;

import cn.yfkj.wxapp.service.admin.SliderManagerService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "管理端轮播设置api")
@CrossOrigin(origins = "*" , maxAge = 3600 , allowCredentials = "true")
@RestController
@RequestMapping(value = "slider")
public class SliderManageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SliderManagerService sliderManagerService;


}
