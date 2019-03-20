package cn.yfkj.wxapp.entity.bo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class PageHelperBO implements Serializable {

    private static final long serialVersionUID = 8576303896328821064L;

    @ApiModelProperty(value = "页数")
    private Integer pageNo;

    @ApiModelProperty(value = "条目数")
    private Integer pageSize;

    @ApiModelProperty(value = "轮播类型")
    private Integer sliderType;

    public Integer getSliderType() {
        return sliderType;
    }

    public void setSliderType(Integer sliderType) {
        this.sliderType = sliderType;
    }

    @ApiModelProperty(value = "搜索关键子")
    private String name;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

    public Integer getPageNo() {
        if (null == pageNo) {
            return 0;
        } else {
            return (pageNo - 1) * getPageSize();
        }
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        if (null == pageSize) {
            return 10;
        } else {
            return pageSize;
        }
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
