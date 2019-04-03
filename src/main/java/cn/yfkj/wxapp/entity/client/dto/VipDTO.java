package cn.yfkj.wxapp.entity.client.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VipDTO implements Serializable {

    private static final long serialVersionUID = 7794116669880915805L;

    private Long id;

    private Float price;

    private Float addPrice;

}
