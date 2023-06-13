package com.example.zdxm_exam.service.impl;

import com.example.zdxm_exam.common.Message;
import com.example.zdxm_exam.dao.GoodsMapper;
import com.example.zdxm_exam.dto.GoodsDto;
import com.example.zdxm_exam.service.info.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper mapper;
    /**
     * @param goodsType
     * @return goods
     * 通过商品类型查询商品
     */

    @Override
    public List<GoodsDto> selectGoodsByGoodsType(String goodsType) {
        List<GoodsDto> goods = mapper.selectGoodsByGoodsType(goodsType);
        return goods;
    }
}
