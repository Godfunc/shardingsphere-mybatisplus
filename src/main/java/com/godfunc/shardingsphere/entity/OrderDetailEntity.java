package com.godfunc.shardingsphere.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_order_detail")
public class OrderDetailEntity {

    @TableId
    private Long id;

    private Long orderId;

    private Long userId;

    private Integer num;

    private Date createTime;
}
