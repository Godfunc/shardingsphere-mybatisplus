package com.godfunc.shardingsphere.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderInfoDTO {

    private Long id;

    private Long userId;

    private Long amount;

    private Date createTime;

    private Integer num;

}
