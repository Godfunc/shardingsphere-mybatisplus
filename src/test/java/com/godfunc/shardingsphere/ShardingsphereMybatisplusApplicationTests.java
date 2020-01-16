package com.godfunc.shardingsphere;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.godfunc.shardingsphere.dto.OrderInfoDTO;
import com.godfunc.shardingsphere.dto.UserOrderDTO;
import com.godfunc.shardingsphere.entity.ConfigEntity;
import com.godfunc.shardingsphere.entity.OrderDetailEntity;
import com.godfunc.shardingsphere.entity.OrderEntity;
import com.godfunc.shardingsphere.entity.UserEntity;
import com.godfunc.shardingsphere.service.ConfigService;
import com.godfunc.shardingsphere.service.OrderDetailService;
import com.godfunc.shardingsphere.service.OrderService;
import com.godfunc.shardingsphere.service.UserService;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShardingsphereMybatisplusApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ConfigService configService;

    /**
     * 添加
     */
    @Test
    void contextLoads() {
        UserEntity userEntity = userService.getById(1210050060746764289L);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setAmount(2120L);
        orderEntity.setCreateTime(new Date());
        orderEntity.setUserId(userEntity.getId());
        orderService.save(orderEntity);
        OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
        orderDetailEntity.setCreateTime(new Date());
        orderDetailEntity.setNum(2);
        orderDetailEntity.setUserId(userEntity.getId());
        orderDetailEntity.setOrderId(orderEntity.getId());
        orderDetailService.save(orderDetailEntity);

    }

    /**
     * 事务
     */
    @Test
    public void createOrder() {
        orderService.createOrder();
    }

    /**
     * 查询
     */
    @Test
    public void page() {
        IPage page = orderService.page1(1, 10, DateTime.now().plusDays(-1).toDate(), "good");
        System.out.println(page);
    }

    /**
     * 查询 in
     */
    @Test
    public void orderList() {
        List<OrderInfoDTO> list = orderService.getListByIds(Arrays.asList(1210050059840794625L, 1210050061740814337L, 1210050061233303554L, 1210081830309462018L));
        System.out.println(list);
    }

    /**
     * 统计
     */
    @Test
    public void orderSum() {
        // 由于t_user 只存在于 m0，不会进行跨库查询，所以执行两句sql，也就是只会在m0中查询
        List<UserOrderDTO> list = orderService.getUserOrder();
        System.out.println(list);
    }

    /**
     * like
     */
    @Test
    public void userList() {
        List<UserEntity> list = userService.list("李四");
        System.out.println(list);
    }

    /**
     * 广播表
     */
    @Test
    public void config() {
        ConfigEntity configEntity = new ConfigEntity();
        configEntity.setName("key1");
        configEntity.setValue("key1");
        configService.save(configEntity);
    }

    /**
     * 查询广播表
     */
    @Test
    public void configList() {
        List<ConfigEntity> list = configService.list();
        System.out.println(list);
    }
}
