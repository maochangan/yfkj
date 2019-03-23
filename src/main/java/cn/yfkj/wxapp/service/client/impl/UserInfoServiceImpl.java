package cn.yfkj.wxapp.service.client.impl;

import cn.yfkj.wxapp.service.client.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserInfoServiceImpl implements UserInfoService {



}
