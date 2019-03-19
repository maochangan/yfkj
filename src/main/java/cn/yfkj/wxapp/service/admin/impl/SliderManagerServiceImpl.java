package cn.yfkj.wxapp.service.admin.impl;

import cn.yfkj.wxapp.dao.admin.SliderManagerDAO;
import cn.yfkj.wxapp.service.admin.SliderManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class SliderManagerServiceImpl implements SliderManagerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SliderManagerDAO sliderManagerDAO;


}
