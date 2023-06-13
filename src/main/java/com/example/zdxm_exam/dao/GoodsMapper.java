package com.example.zdxm_exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.zdxm_exam.dto.GoodsDto;
import com.example.zdxm_exam.pojo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     *根据商品类型查询所有商品列表
     */
    List<GoodsDto> selectGoodsByGoodsType(String goodsType);
    /**
     *通过商品id查询商品价格
     */
    GoodsDto selectGoodsById(Integer goodsId);
}
