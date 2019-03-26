package cn.yfkj.wxapp.entity.admin.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ManageGoodsAddBO implements Serializable {

    private static final long serialVersionUID = -7448678435834283695L;

    @ApiModelProperty(value = "名称", required = true)
    @NotEmpty(message = "not null")
    private String goodName;

    @ApiModelProperty(value = "图片地址", required = true)
    @NotEmpty(message = "not null")
    private String goodImgUrl;

    @ApiModelProperty(value = "价格", required = true)
    @NotNull(message = "not null")
    private Float goodPrize;

    @ApiModelProperty(value = "销量，后台可改但不建议", required = true)
    @NotNull(message = "not null")
    private Long goodSales;

    @ApiModelProperty(value = "描述", required = true)
    @NotEmpty(message = "not null")
    private String goodInfo;

    @ApiModelProperty(value = "标签", required = true)
    @NotEmpty(message = "not null")
    private String goodTips;

    @ApiModelProperty(value = "所属菜单id", required = true)
    @NotNull(message = "not null")
    private Long menuID;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "not null")
    private Integer status;


}
