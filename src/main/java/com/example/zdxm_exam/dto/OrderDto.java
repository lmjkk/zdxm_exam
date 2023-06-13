package com.example.zdxm_exam.dto;

import com.example.zdxm_exam.pojo.Order;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDto extends Order {
    private String name;
    private BigDecimal goodsPrice;
    private Integer discount;
    private Integer subtract;
    private Integer num;
    private String goodPayPrice;
}
