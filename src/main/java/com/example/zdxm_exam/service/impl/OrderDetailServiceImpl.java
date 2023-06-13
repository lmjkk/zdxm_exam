package com.example.zdxm_exam.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.zdxm_exam.dao.GoodsMapper;
import com.example.zdxm_exam.dao.OrderDetailMapper;
import com.example.zdxm_exam.dao.OrderMapper;
import com.example.zdxm_exam.dto.GoodsDto;
import com.example.zdxm_exam.pojo.Order;
import com.example.zdxm_exam.pojo.OrderDetail;
import com.example.zdxm_exam.service.info.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper,OrderDetail> implements OrderDetailService{
    @Autowired
    private OrderDetailMapper mapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OrderMapper orderMapper;
    //这里的num是下单的商品的数量，需要判断goodsId集合中相同的有几个。
    @Override
    public Boolean insertOrderDetail(List<Integer> goodsId, Integer orderId) {
        Integer num = 1;
        OrderDetail orderDetail = new OrderDetail();
        List list = new ArrayList();
        //每个商品打折后的价格
        BigDecimal discountPrice = new BigDecimal("0");
        for(int i=0;i<goodsId.size();i++){
            //通过商品id查询获取商品价格，折扣id,折扣价格
            GoodsDto goodsDto = goodsMapper.selectGoodsById(goodsId.get(i));
            orderDetail.setGoodsId(goodsId.get(i));
            orderDetail.setOrderId(orderId);
            orderDetail.setGoodsPrice(goodsDto.getPrice());
            orderDetail.setDiscountId(goodsDto.getId());
            if(goodsDto.getDiscount()!=null){
                //计算折扣后的钱
                discountPrice = goodsDto.getPrice().multiply(goodsDto.getDiscount());
            }
            if(goodsDto.getSubtract()!=null){
                discountPrice = goodsDto.getPrice().subtract(goodsDto.getSubtract());
            }
            orderDetail.setPayPrice(discountPrice.toString());
            for(int j=i+1;j<goodsId.size();j++){
                if(goodsId.get(i)==goodsId.get(j)){
                    num++;
                }
            }
            orderDetail.setNum(num);
            Timestamp date = new Timestamp(new Date().getTime());
            orderDetail.setCreateTime(date);
            orderDetail.setState(1);
            //将orderDetail放到list中
            list.add(orderDetail);

        }
        boolean insertList = saveBatch(list);
        System.out.println("list2"+list);
        return insertList;
    }

    @Override
    public Order listOrderIdByTime(Timestamp createTime) {
        return orderMapper.listOrderIdByTime(createTime);
    }

}
