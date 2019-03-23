package cn.yfkj.wxapp.entity.client.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MenuDTO implements Serializable {

    private static final long serialVersionUID = -6152468972391314449L;

    private Long id;

    private String menuName;

    private String menuImgUrl;

    private String menuLinkUrl;

}
