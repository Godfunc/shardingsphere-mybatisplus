package com.godfunc.shardingsphere.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godfunc.shardingsphere.entity.OrderDetailEntity;
import com.godfunc.shardingsphere.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService extends ServiceImpl<OrderDetailMapper, OrderDetailEntity> {
}
