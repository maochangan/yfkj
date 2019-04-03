package cn.yfkj.wxapp.entity.client.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UserBO implements Serializable {

    private static final long serialVersionUID = -5469275522259596470L;

    @ApiModelProperty(value = "openID", required = true)
    @NotEmpty(message = "not null")
    private String openID;

}
