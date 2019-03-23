package cn.yfkj.wxapp.entity.client.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = -7617281553001457813L;

    private Long id;

    private String openID;

    private String nickName;

    private String avatarUrl;

    private String city;

    private String country;

    private String language;

    private Integer gender;

    private String province;

    private Integer status;

    private String gmtCreate;

    private String gmtModified;

}
