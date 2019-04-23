package cn.yfkj.wxapp.service.client;

import cn.yfkj.wxapp.entity.client.bo.UserAddressAddBO;
import cn.yfkj.wxapp.entity.client.bo.UserAddressUpdateBO;
import cn.yfkj.wxapp.entity.client.bo.UserBO;
import cn.yfkj.wxapp.entity.client.dto.UserAddressDTO;
import cn.yfkj.wxapp.utils.project.SerResult;

import java.util.List;

public interface UserAddressService {

    public SerResult<List<UserAddressDTO>> getList(UserBO user);


    public SerResult<Boolean> addAddress(UserAddressAddBO address);

    public SerResult<Boolean> updateAddress(UserAddressUpdateBO userAddress);
}
