package cn.yfkj.wxapp.entity.client.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserAddressUpdateBO implements Serializable {

    private static final long serialVersionUID = -2560404267806286524L;

    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "not null")
    private Long id;

    @ApiModelProperty(value = "姓名", required = true)
    @NotEmpty(message = "not null")
    private String name;

    @ApiModelProperty(value = "地址", required = true)
    @NotEmpty(message = "not null")
    private String address;


    @ApiModelProperty(value = "手机号", required = true)
    @NotEmpty(message = "not null")
    private String mobile;

    @ApiModelProperty(value = "巨离", required = true)
    @NotNull(message = "not null")
    private Float distance;



}
