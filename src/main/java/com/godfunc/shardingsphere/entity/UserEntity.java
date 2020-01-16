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
@TableName("t_user")
public class UserEntity {

    public UserEntity(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    @TableId
    private Long id;

    private String name;

    private Date createTime;
}
