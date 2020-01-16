package com.godfunc.shardingsphere.dto;

import lombok.Data;

@Data
public class UserOrderDTO {

    private Long id;

    private String name;

    private Long totalAmount;

    private Integer count;
}
