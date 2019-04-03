package cn.yfkj.wxapp.entity.admin.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class VipManageAddBO implements Serializable {

    private static final long serialVersionUID = 929808812155375141L;

    @ApiModelProperty(value = "价格", required = true)
    @NotNull(message = "not null")
    private Float price;

    @ApiModelProperty(value = "赠送价格", required = true)
    @NotNull(message = "not null")
    private Float addPrice;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "not null")
    private Integer status;

}
