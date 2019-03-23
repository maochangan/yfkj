package cn.yfkj.wxapp.controller.client;

import cn.yfkj.wxapp.entity.client.bo.AutoCode;
import cn.yfkj.wxapp.entity.client.bo.UserInfoUpdateOrAddBO;
import cn.yfkj.wxapp.entity.client.dto.UserInfoDTO;
import cn.yfkj.wxapp.service.client.UserInfoService;
import cn.yfkj.wxapp.utils.project.ResultMap;
import cn.yfkj.wxapp.utils.project.SerResult;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户信息api")
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping(value = "user")
public class UserInfoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoService userInfoService;

    @Value("${project.appID}")
    private String appID;

    @Value("${project.script}")
    private String script;

    @ApiOperation(value = "获取openID 弃用")
    @PostMapping(value = "getOpenID")
    public ResultMap getOpenID(@RequestBody @Validated @ModelAttribute("auto") AutoCode auto){
        try {
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+ appID +"&secret="+ script +"&js_code="+ auto.getCode() +"&grant_type=authorization_code";
            JSONObject jsonObject = null;
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                String result = EntityUtils.toString(entity, "UTF-8");
                jsonObject = JSONObject.parseObject(result);
                String openID = jsonObject.getString("openid");
                return ResultMap.createMap("success", 1).addDate(openID);
            }else{
                return ResultMap.createMap("fail", 0);
            }
        } catch (Exception e) {
            logger.error("获取openID 异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }

    @ApiOperation(value = "添加用户和更新用户信息")
    @PostMapping(value = "userInfo")
    public ResultMap userInfo(@RequestBody @Validated @ModelAttribute("userInfo") UserInfoUpdateOrAddBO userInfo){
        try {
            SerResult<UserInfoDTO> result = userInfoService.getUserInfo(userInfo);
            if (result.isSuccess()) {
                BeanUtils.copyProperties(userInfo, result.getValue());
                SerResult<Boolean> updateResult = userInfoService.updateUserInfo(result.getValue());
                if (updateResult.isSuccess()) {
                    return ResultMap.createMap("success", 1);
                }else{
                    return ResultMap.createMap("fail", 0);
                }
            }else{
                SerResult<Boolean> addResult = userInfoService.addUserInfo(userInfo);
                if (addResult.isSuccess()) {
                    return ResultMap.createMap("success", 1);
                }else{
                    return ResultMap.createMap("fail", 0);
                }
            }
        } catch (Exception e) {
            logger.error("更新用户和新增用户信息异常：" + e.getMessage());
            return ResultMap.createMap("err", -1);
        }
    }


}
