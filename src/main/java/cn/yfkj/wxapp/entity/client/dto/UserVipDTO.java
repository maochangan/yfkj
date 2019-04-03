package cn.yfkj.wxapp.entity.client.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVipDTO implements Serializable {

    private static final long serialVersionUID = -8780128646715425068L;

    private Long id;

    private String openID;

    private Float vipBalance;

    private Long vipIntegral;

}
