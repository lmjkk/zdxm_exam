package com.example.zdxm_exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.zdxm_exam.dto.OrderDto;
import com.example.zdxm_exam.pojo.Order;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
    Order listOrderIdByTime(Timestamp createTime);
    List<OrderDto> selectOrder(Integer orderId);
}
