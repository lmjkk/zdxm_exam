package com.example.zdxm_exam.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName("b_shopping")
public class Shopping {
    @TableId(type= IdType.AUTO)
    @JsonIgnore
//    购物车id
    private Integer id;
//    商品id
    @JsonIgnore
    private Integer goodsId;
//    用户编号
    @JsonIgnore
    private Integer userId;
//    数量
    private Integer num;
    @JsonIgnore
//    状态
    private Integer state;
}
