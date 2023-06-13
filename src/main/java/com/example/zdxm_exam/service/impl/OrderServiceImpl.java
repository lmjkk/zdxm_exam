package com.example.zdxm_exam.service.impl;

import com.example.zdxm_exam.dao.GoodsMapper;
import com.example.zdxm_exam.dao.OrderMapper;
import com.example.zdxm_exam.dto.GoodsDto;
import com.example.zdxm_exam.dto.OrderDto;
import com.example.zdxm_exam.pojo.Order;
import com.example.zdxm_exam.service.info.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    //获取mapper
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    /**
     * 插入订单
     * 通过所给的用户和商品id,获取所有商品的价格,算出总价,判断是否需要邮费,算出支付价格
     */
    public Order insertOrder(Integer userId, List goodsId) {

        Order order = new Order();
        //没有打折的总价
        BigDecimal totalPrice = new BigDecimal("0");
        //打折后的总支付价
        BigDecimal payPrice = new BigDecimal("0");
        //每个商品打折后的价格
        BigDecimal discountPrice = new BigDecimal("0");
        for(int i=0;i<goodsId.size();i++){
            //首先通过goodsId获取商品信息
            GoodsDto goodsDto = goodsMapper.selectGoodsById((Integer) goodsId.get(i));
            if(goodsDto.getDiscount()!=null){
                //计算折扣后的钱
                discountPrice = goodsDto.getPrice().multiply(goodsDto.getDiscount());
            }
            if(goodsDto.getSubtract()!=null){
                discountPrice = goodsDto.getPrice().subtract(goodsDto.getSubtract());
            }
            //获取订单支付总价
            payPrice = payPrice.add(discountPrice);
            //获取订单总价
            totalPrice = totalPrice.add(goodsDto.getPrice());
        }
        BigDecimal frankPrice = new BigDecimal("90");
        int flag = totalPrice.compareTo(frankPrice);
        //当邮费>90时，免邮费
        if(flag==1){
            order.setFranking(new BigDecimal("0"));
        }else {
            order.setFranking(new BigDecimal("10"));
        }
        order.setTotalPrice(totalPrice);
        order.setPayPrice(payPrice);
        order.setUserId(userId);
        Timestamp date = new Timestamp(new Date().getTime());
        order.setCreateTime(date);
        order.setState(1);
        Integer insertOrder = orderMapper.insert(order);
        return order;
    }

    /**
     * 查询订单及订单详情
     *
     * @param orderId
     */
    @Override
    public List<OrderDto> orderDtoList(Integer orderId) {
        return orderMapper.selectOrder(orderId);
    }

}
