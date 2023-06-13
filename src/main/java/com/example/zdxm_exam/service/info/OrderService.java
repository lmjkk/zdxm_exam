package com.example.zdxm_exam.service.info;

import com.example.zdxm_exam.dto.OrderDto;
import com.example.zdxm_exam.pojo.Order;
import com.example.zdxm_exam.pojo.OrderDetail;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 插入订单
 * 通过所给的用户和商品id,获取所有商品的价格,算出总价,判断是否需要邮费,算出支付价格
 */
public interface OrderService {
    Order insertOrder(Integer userId, List goodsId);
    /**
     * 查询订单及订单详情
     */
    List<OrderDto> orderDtoList(Integer orderId);
}
