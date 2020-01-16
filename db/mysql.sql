CREATE DATABASE shardingsphere;
USE shardingsphere;
CREATE TABLE `t_order_0` (
    `id` BIGINT(16) NOT NULL,
    `user_id` BIGINT(16) NOT NULL COMMENT '客户id',
    `amount` BIGINT(16) NOT NULL COMMENT '订单金额',
    `create_time` DATETIME COMMENT '创建时间',
    PRIMARY KEY (`id`)
) COMMENT '订单表';

CREATE TABLE `t_order_detail_0` (
    `id` BIGINT(16) NOT NULL,
    `order_id` BIGINT(16) NOT NULL,
    `user_id` BIGINT(16) NOT NULL,
    `num` INT NOT NULL,
    `create_time` DATETIME COMMENT '创建时间',
    PRIMARY KEY (`id`)
) COMMENT '订单详细表';

CREATE TABLE `t_order_1` (
    `id` BIGINT(16) NOT NULL,
    `user_id` BIGINT(16) NOT NULL COMMENT '客户id',
    `amount` BIGINT(16) NOT NULL COMMENT '订单金额',
    `create_time` DATETIME COMMENT '创建时间',
    PRIMARY KEY (`id`)
) COMMENT '订单表';

CREATE TABLE `t_order_detail_1` (
    `id` BIGINT(16) NOT NULL,
    `order_id` BIGINT(16) NOT NULL,
    `user_id` BIGINT(16) NOT NULL,
    `num` INT NOT NULL,
    `create_time` DATETIME COMMENT '创建时间',
    PRIMARY KEY (`id`)
) COMMENT '订单详细表';

CREATE TABLE `t_user` (
    `id` BIGINT(16) NOT NULL,
    `name` VARCHAR(128) NOT NULL COMMENT '用户名',
    `create_time` DATETIME COMMENT '创建时间',
    PRIMARY KEY (`id`)
) COMMENT '用户表';

CREATE TABLE `t_config` (
    `id` BIGINT(16) NOT NULL,
    `name` VARCHAR(128) NOT NULL,
    `VALUE` VARCHAR(128) NOT NULL,
    PRIMARY KEY (`id`)
) COMMENT '配置表';