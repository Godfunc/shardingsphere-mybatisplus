package com.godfunc.shardingsphere.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godfunc.shardingsphere.entity.UserEntity;
import com.godfunc.shardingsphere.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {

    public List<UserEntity> list(String name) {
        return this.baseMapper.selectList(name);
    }
}
