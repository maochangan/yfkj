package cn.yfkj.wxapp.entity.admin.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VipManageDTO implements Serializable {

    private static final long serialVersionUID = -6931372851948958325L;

    private Long id;

    private Float price;

    private Float addPrice;

    private Integer status;

    private String gmtCreate;

    private String gmtModified;


}
