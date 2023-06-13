package com.example.zdxm_exam.service.info;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.zdxm_exam.pojo.Order;
import com.example.zdxm_exam.pojo.OrderDetail;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDetailService extends IService<OrderDetail> {
    Boolean insertOrderDetail(List<Integer> goodsId, Integer orderId);

    Order listOrderIdByTime(Timestamp createTime);
}
