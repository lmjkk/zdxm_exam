package com.example.zdxm_exam.service.info;

import com.example.zdxm_exam.dto.GoodsDto;
import com.example.zdxm_exam.pojo.Goods;

import java.util.List;

public interface GoodsService {
    /**
     *
     * @param goodsType
     * @return goods
     * 通过商品类型查询商品
     */
    List<GoodsDto> selectGoodsByGoodsType(String goodsType);

}
