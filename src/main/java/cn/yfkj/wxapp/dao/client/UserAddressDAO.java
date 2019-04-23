package cn.yfkj.wxapp.dao.client;

import cn.yfkj.wxapp.entity.client.bo.UserAddressAddBO;
import cn.yfkj.wxapp.entity.client.bo.UserAddressUpdateBO;
import cn.yfkj.wxapp.entity.client.bo.UserBO;
import cn.yfkj.wxapp.entity.client.dto.UserAddressDTO;

import java.util.List;

public interface UserAddressDAO {

    public List<UserAddressDTO> getList(UserBO user);

    public int addAddress(UserAddressAddBO address);

    public int updateAddress(UserAddressUpdateBO userAddress);
}
