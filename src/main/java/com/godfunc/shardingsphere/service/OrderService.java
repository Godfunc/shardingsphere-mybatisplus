package com.godfunc.shardingsphere.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.godfunc.shardingsphere.dto.OrderInfoDTO;
import com.godfunc.shardingsphere.dto.UserOrderDTO;
import com.godfunc.shardingsphere.entity.OrderDetailEntity;
import com.godfunc.shardingsphere.entity.OrderEntity;
import com.godfunc.shardingsphere.entity.UserEntity;
import com.godfunc.shardingsphere.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapper, OrderEntity> {

    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private UserService userService;

    public IPage<OrderInfoDTO> page1(int page, int limit, Date date, String name) {
        IPage<OrderInfoDTO> resultPage = new Page<>(page, limit);
        return resultPage.setRecords(this.baseMapper.selectPage1(resultPage, date, name));
    }

    public List<OrderInfoDTO> getListByIds(List<Long> ids) {
        return this.baseMapper.selectListByIds(ids);
    }

    public List<UserOrderDTO> getUserOrder() {
        return this.baseMapper.selectUserOrder();
    }

    @Transactional
    public void createOrder() {
        for (int i = 0; i < 10; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(i+"");
            userEntity.setCreateTime(new Date());
            userService.save(userEntity);
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setAmount(22331L);
            orderEntity.setCreateTime(new Date());
            orderEntity.setUserId(userEntity.getId());
            save(orderEntity);
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setCreateTime(new Date());
            orderDetailEntity.setNum(2);
            orderDetailEntity.setUserId(userEntity.getId());
            orderDetailEntity.setOrderId(orderEntity.getId());
            orderDetailService.save(orderDetailEntity);
            if(i==8) {
                 throw new RuntimeException("error");
            }
        }

    }
}
