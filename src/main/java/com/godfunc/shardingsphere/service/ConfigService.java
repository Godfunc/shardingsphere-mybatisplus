package com.godfunc.shardingsphere.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godfunc.shardingsphere.entity.ConfigEntity;
import com.godfunc.shardingsphere.entity.UserEntity;
import com.godfunc.shardingsphere.mapper.ConfigMapper;
import com.godfunc.shardingsphere.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService extends ServiceImpl<ConfigMapper, ConfigEntity> {

}
