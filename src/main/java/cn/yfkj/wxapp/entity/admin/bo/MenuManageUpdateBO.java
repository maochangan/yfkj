package cn.yfkj.wxapp.entity.admin.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class MenuManageUpdateBO implements Serializable {

    private static final long serialVersionUID = -2798058270195807998L;

    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "not  null")
    private Long id;

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
