package com.example.zdxm_exam.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@TableName("b_goods")
public class Goods {
    @TableId(type= IdType.AUTO)
//    商品id
    @JsonIgnore
    private Integer id;
//    商品类型
    @JsonIgnore
    private String type;
//    商品名称
    private String name;
//    商品生产商
    @JsonIgnore
    private String producer;
//    价格(decimal--->BigDecimal)
    private BigDecimal price;
//    上架状态
    @JsonIgnore
    private Integer publishState;
//    上架时间(datetime--->Timestamp)
    @JsonIgnore
    private Timestamp publishTime;
//    创建时间
    @JsonIgnore
    private Timestamp createTime;
//    状态
    @JsonIgnore
    private Integer state;
}
