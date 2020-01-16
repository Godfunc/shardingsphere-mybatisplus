package com.godfunc.shardingsphere.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.godfunc.shardingsphere.dto.OrderInfoDTO;
import com.godfunc.shardingsphere.dto.UserOrderDTO;
import com.godfunc.shardingsphere.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapper extends BaseMapper<OrderEntity> {
    List<OrderInfoDTO> selectPage1(IPage page, @Param("createTime") Date createTime, @Param("name") String name);

    List<OrderInfoDTO> selectListByIds(@Param("ids") List<Long> ids);

    List<UserOrderDTO> selectUserOrder();

}
