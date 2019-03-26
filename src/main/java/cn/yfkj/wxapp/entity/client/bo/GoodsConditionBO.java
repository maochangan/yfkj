package cn.yfkj.wxapp.entity.client.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class GoodsConditionBO implements Serializable {

    private static final long serialVersionUID = 2479653410966736383L;

    @ApiModelProperty(value = "所属id", required = true)
    @NotNull(message = "not null")
    private Long menuID;

    @ApiModelProperty(value = "用户openID", required = true)
    @NotEmpty(message = "not null")
    private String openID;


}
