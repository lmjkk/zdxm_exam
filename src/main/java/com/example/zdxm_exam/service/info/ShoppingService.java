package com.example.zdxm_exam.service.info;

import com.example.zdxm_exam.dto.ShoppingDto;

import java.util.List;

/**
 * 插入购物车
 */
public interface ShoppingService {
    /**
     *
     * @param goodsId
     * @param userId
     * @param num
     * @return
     * 插入购物车数据
     */
    int insertShopping(Integer goodsId, Integer userId, Integer num);

    /**
     * 通过用户查询购物车
     * @param userId
     * @return
     */
    List<ShoppingDto> listShoppingByUserId(Integer userId);
}
