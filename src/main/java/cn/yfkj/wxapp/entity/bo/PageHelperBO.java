package cn.yfkj.wxapp.entity.bo;

import java.io.Serializable;

public class PageHelperBO implements Serializable {

    private Integer pageNum;

    private Integer pageSize;

    private Integer sliderType;

    public Integer getSliderType() {
        return sliderType;
    }

    public void setSliderType(Integer sliderType) {
        this.sliderType = sliderType;
    }


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        if (null == pageNum) {
            this.pageNum = 1;
        } else {
            this.pageNum = pageNum;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (null == pageSize) {
            this.pageSize = 1;
        } else {
            this.pageSize = (this.pageNum - 1) * this.pageSize;
        }
    }


}
