package cn.yfkj.wxapp.entity.client.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SliderDTO implements Serializable {

    private static final long serialVersionUID = 7112690250477174785L;

    /**
     * id
     */
    private Long id;

    /**
     * 轮播名称
     */
    private String sliderName;

    /**
     * 轮播图片地址
     */
    private String sliderImgUrl;

    /**
     * 轮播链接地址
     */
    private String sliderLinkUrl;

    /**
     * 轮播类型 1 首页 2 其他
     */
    private Integer sliderType;

}
