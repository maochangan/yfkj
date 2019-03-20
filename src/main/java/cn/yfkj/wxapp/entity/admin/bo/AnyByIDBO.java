package cn.yfkj.wxapp.entity.admin.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AnyByIDBO implements Serializable {

    private static final long serialVersionUID = 8537083183818951133L;

    @ApiModelProperty(value = "id")
    @NotNull(message = "not null")
    private Long id;

}

