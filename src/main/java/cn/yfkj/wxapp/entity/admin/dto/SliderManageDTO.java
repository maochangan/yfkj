package cn.yfkj.wxapp.entity.admin.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SliderManageDTO implements Serializable {

    private static final long serialVersionUID = 5744879042175418583L;

    /**
     * id
     */
    private Long id;

    /**
     * 轮播名称
     */
    private String sliderName;

    /**
     * 图片地址
     */
    private String sliderImgUrl;

    /**
     * 链接地址
     */
    private String sliderLinkUrl;

    /**
     * 类型
     */
    private Integer sliderType;

    /**
     * 创建时间
     */
    private String gmtCreate;

    /**
     * 修改时间
     */
    private String gmtModified;

    /**
     * 状态
     */
    private Integer status;

}
