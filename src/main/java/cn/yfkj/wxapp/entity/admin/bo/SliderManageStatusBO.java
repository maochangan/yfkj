package cn.yfkj.wxapp.entity.admin.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class SliderManageStatusBO implements Serializable {

    private static final long serialVersionUID = 3536783578762204034L;

    @ApiModelProperty(value = "id")
    @NotNull(message = "not null")
    private Long id;

    @ApiModelProperty(value = "status")
    @NotNull(message = "not null")
    private Integer status;

}
