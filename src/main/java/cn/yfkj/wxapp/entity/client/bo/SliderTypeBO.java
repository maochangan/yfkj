package cn.yfkj.wxapp.entity.client.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class SliderTypeBO implements Serializable {

    private static final long serialVersionUID = 1495355021050303502L;

    @ApiModelProperty(value = "轮播图类型" , required = true)
    @NotNull(message = "not null")
    private Integer sliderType;

}
