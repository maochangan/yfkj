package cn.yfkj.wxapp.entity.admin.bo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class GoodManagePageBO implements Serializable {

    private static final long serialVersionUID = -5848164556075102963L;

    @ApiModelProperty(value = "页数")
    private Integer pageNo;

    @ApiModelProperty(value = "条目数")
    private Integer pageSize;

    @ApiModelProperty(value = "所属类型")
    private Long menuID;

    public Long getMenuID() {
        return menuID;
    }

    public void setMenuID(Long menuID) {
        this.menuID = menuID;
    }

    @ApiModelProperty(value = "搜索关键字")
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
