package com.example.zdxm_exam.controller;

import com.example.zdxm_exam.common.Message;
import com.example.zdxm_exam.dto.OrderDto;
import com.example.zdxm_exam.pojo.Goods;
import com.example.zdxm_exam.pojo.Order;
import com.example.zdxm_exam.pojo.OrderDetail;
import com.example.zdxm_exam.service.info.OrderDetailService;
import com.example.zdxm_exam.service.info.OrderService;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/insert")
    public Message<Order> insertOrder(Integer userId, @RequestParam("goodsId") List<Integer> goodsId){
        System.out.println("--------------------------------");
        System.out.println("商品："+goodsId);

        if(userId==null||goodsId.size()==0){
            return new Message().setCode(401).setMessage("数据为空");
        }
        Order order = service.insertOrder(userId,goodsId);
        /**
         * 通过时间查询订单
         */
//        Order orderId = orderDetailService.listOrderIdByTime(order.getCreateTime());
        /**
         * 订单详情插入
         */
        Boolean insertList = orderDetailService.insertOrderDetail(goodsId,order.getId());
        return new Message().setCode(200).setData(insertList).setMessage("插入成功");
    }
    /**
     * 查询订单及订单详情
     */
    @PostMapping("/list")
    Message<OrderDto> OrderList(Integer orderId){
        List<OrderDto> orderList =  service.orderDtoList(orderId);
        System.out.println(orderList);
        return new Message().setCode(200).setData(orderList).setMessage("订单查询成功");
    }
}
