package com.example.zdxm_exam.dto;

import com.example.zdxm_exam.pojo.Shopping;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShoppingDto extends Shopping {
//    商品名称
    private String name;
//    商品价格
    private BigDecimal price;
//    商品折扣
    private BigDecimal discount;
//    商品满减
    private BigDecimal subtract;
}
