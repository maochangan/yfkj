package cn.yfkj.wxapp.entity.admin.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class MenuManageAddBO implements Serializable {

    private static final long serialVersionUID = 6673623155357897261L;

    @ApiModelProperty(value = "菜单名称" , required = true)
    @NotEmpty(message = "not null")
    private String menuName;

    @ApiModelProperty(value = "菜单链接地址", required = true)
    @NotEmpty(message = "not null")
    private String menuImgUrl;

    @ApiModelProperty(value = "链接地址", required = true)
    @NotEmpty(message = "not null")
    private String menuLinkUrl;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "not null")
    private Integer status;



}
