package cn.yfkj.wxapp.entity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author maochangan
 */
@Data
public class AdminUser implements Serializable {

    private static final long serialVersionUID = -7020097933317729330L;

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String adminName;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String adminPassword;


}
