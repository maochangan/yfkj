package cn.yfkj.wxapp.entity.admin.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuManageDTO implements Serializable {

    private static final long serialVersionUID = 1799276157915931267L;

    private Long id;

    private String menuName;

    private String menuImgUrl;

    private String menuLinkUrl;

    private Integer status;

    private String gmtCreate;

    private String gmtModified;

}
