package cn.yfkj.wxapp.entity.admin.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserInfoBO implements Serializable {

    private static final long serialVersionUID = -252646360987826840L;

    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "not null")
    private Long id;

    @ApiModelProperty(value = "用户名" , required = true)
    @NotEmpty(message = "not null")
    private String userName;

}
