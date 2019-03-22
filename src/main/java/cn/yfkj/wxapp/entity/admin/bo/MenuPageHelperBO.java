package cn.yfkj.wxapp.entity.admin.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MenuPageHelperBO implements Serializable {

    private static final long serialVersionUID = 3852169246420780956L;

    @ApiModelProperty(value = "页数")
    private Integer pageNo;

    @ApiModelProperty(value = "条目数")
    private Integer pageSize;

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

}
