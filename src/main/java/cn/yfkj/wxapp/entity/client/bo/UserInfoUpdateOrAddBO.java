package cn.yfkj.wxapp.entity.client.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UserInfoUpdateOrAddBO implements Serializable {

    private static final long serialVersionUID = -3545179880926211599L;

    @ApiModelProperty(value = "openid" , required = true)
    @NotEmpty(message = "not null")
    private String openID;

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "not null")
    private String nickName;

    @ApiModelProperty(value = "头像", required = true)
    @NotEmpty(message = "not null")
    private String avatarUrl;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "国籍")
    private String country;

    @ApiModelProperty(value = "语言")
    private String language;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "省份")
    private String province;


}
