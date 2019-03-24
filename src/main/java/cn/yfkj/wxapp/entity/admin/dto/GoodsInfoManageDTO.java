package cn.yfkj.wxapp.entity.admin.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsInfoManageDTO implements Serializable {

    private static final long serialVersionUID = -6498343843165682450L;

    private Long id;

    private Long menuID;

    private String goodName;

    private String goodImgUrl;

    private String goodInfo;

    private String goodTips;

    private Float goodPrize;

    private Long goodSales;

    private Integer status;

    private String gmtCreate;

    private String gmtModified;


}
