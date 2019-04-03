package cn.yfkj.wxapp.entity.client.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsInfoDTO implements Serializable {

    private static final long serialVersionUID = 4448019610712074691L;

    private Long id;

    private Long menuID;

    private String goodName;

    private String goodImgUrl;

    private String goodInfo;

    private String goodTips;

    private Float goodPrize;

    private Long goodSales;

    private Integer num;

}
