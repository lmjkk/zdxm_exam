package com.example.zdxm_exam.service.impl;

import com.example.zdxm_exam.dao.ShoppingMapper;
import com.example.zdxm_exam.dto.ShoppingDto;
import com.example.zdxm_exam.pojo.Shopping;
import com.example.zdxm_exam.service.info.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    private ShoppingMapper mapper;
    public final Integer SHOPPING_STATE = 1;
    /**
     * @param goodsId
     * @param userId
     * @param num
     * @return 插入购物车数据
     */
    @Override
    public int insertShopping(Integer goodsId, Integer userId, Integer num) {
        Shopping shopping = new Shopping();
        shopping.setGoodsId(goodsId);
        shopping.setUserId(userId);
        shopping.setNum(num);
        shopping.setState(SHOPPING_STATE);
        int insert =  mapper.insert(shopping);
        if(insert>0){
            return insert;
        }else {
            return 0;

        }
    }

    /**
     * 通过用户查询购物车
     *
     * @param userId
     * @return
     */
    @Override
    public List<ShoppingDto> listShoppingByUserId(Integer userId) {
        return mapper.listShoppingByUserId(userId);
    }

}
