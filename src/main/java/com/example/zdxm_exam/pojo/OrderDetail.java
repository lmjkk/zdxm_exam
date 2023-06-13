package com.example.zdxm_exam.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@TableName("b_order_detail_info")
public class OrderDetail {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer goodsId;
    private Integer orderId;
    private BigDecimal goodsPrice;
    private Integer discountId;
    private Integer num;
    private String payPrice;
    private Timestamp createTime;
    private Integer state;

}
