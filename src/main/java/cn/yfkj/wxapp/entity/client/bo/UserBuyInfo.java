package cn.yfkj.wxapp.entity.client.bo;

import cn.yfkj.wxapp.entity.client.dto.GoodsInfoDTO;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class UserBuyInfo implements Serializable {

    private static final long serialVersionUID = -673843247424257050L;

    @ApiModelProperty(value = "用户唯一id", required = true)
    @NotEmpty(message = "not null")
    private String openID;

    @ApiModelProperty(value = "交易总额", required = true)
    @NotNull(message = "not null")
    private Float total;

    @ApiModelProperty(value = "产品列表", required = true)
    @NotNull(message = "not null")
    private List<GoodsInfoDTO> goodsList;


    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public List<GoodsInfoDTO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(String goodsList) {
        this.goodsList = JSON.parseArray(goodsList , GoodsInfoDTO.class);
    }
}
