package com.example.zdxm_exam.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 下单功能实体类
 */
@Data
@TableName("b_order_info")
public class Order {
    @TableId(type= IdType.AUTO)
//    订单编号
    private Integer id;
//    用户id
    @JsonIgnore
    private Integer userId;
//    商品总价
    private BigDecimal totalPrice;
//    邮费
    private BigDecimal franking;
//    优惠后的支付价格
    private BigDecimal payPrice;
//    添加时间
    @JsonIgnore
    private Timestamp createTime;
//    订单状态
    @JsonIgnore
    private Integer state;
}
