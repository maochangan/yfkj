package cn.yfkj.wxapp.entity.admin.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class SliderManageUpdateBO implements Serializable {

    private static final long serialVersionUID = 6628267920540679778L;

    @ApiModelProperty(value = "id")
    @NotNull(message = "not null")
    private Long id;

    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "not null")
    private String sliderName;

    @ApiModelProperty(value = "图片地址")
    @NotEmpty(message = "not null")
    private String sliderImgUrl;

    @ApiModelProperty(value = "链接地址")
    @NotEmpty(message = "not null")
    private String sliderLinkUrl;

    @ApiModelProperty(value = "类型")
    @NotNull(message = "not null")
    private Integer sliderType;

    @ApiModelProperty(value = "状态")
    @NotNull(message = "not null")
    private Integer status;
}
