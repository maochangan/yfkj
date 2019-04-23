package cn.yfkj.wxapp.entity.client.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserAddressAddBO implements Serializable {

    private static final long serialVersionUID = 338644594368402317L;

    @ApiModelProperty(value = "openID", required = true)
    @NotEmpty(message = "not null")
    private String openID;

    @ApiModelProperty(value = "地址", required = true)
    @NotEmpty(message = "not null")
    private String address;

    @ApiModelProperty(value = "手机号", required = true)
    @NotEmpty(message = "not null")
    private String mobile;

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "not null")
    private String name;

    @ApiModelProperty(value = "距离", required = true)
    @NotNull(message = "not null")
    private Float distance;



}
