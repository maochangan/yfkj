package cn.yfkj.wxapp.entity.client.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAddressDTO implements Serializable {

    private static final long serialVersionUID = 7045504493847268329L;

    private Long id;

    private String openID;

    private String address;

    private String mobile;

    private String name;

    private Float distance;

    private Integer status;

    private String gmtCreate;

    private String gmtModified;


}
