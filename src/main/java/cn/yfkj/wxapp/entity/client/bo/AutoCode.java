package cn.yfkj.wxapp.entity.client.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class AutoCode implements Serializable {

    private static final long serialVersionUID = 5536111819003096937L;

    @ApiModelProperty(value = "code", required = true)
    @NotEmpty(message = "code不能为空")
    private String code;
}
