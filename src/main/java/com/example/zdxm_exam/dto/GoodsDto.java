package com.example.zdxm_exam.dto;

import com.example.zdxm_exam.pojo.Goods;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsDto extends Goods {
//    商品打折
    private BigDecimal discount;
//    商品满减
    private BigDecimal subtract;
    //打折id
    private Integer id;
}
