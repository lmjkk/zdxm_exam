package com.example.zdxm_exam.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.zdxm_exam.common.Message;
import com.example.zdxm_exam.dto.GoodsDto;

import com.example.zdxm_exam.service.info.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/goods")

public class GoodsController {
    @Autowired
    private GoodsService service;
    @PostMapping("/list")
    public Message<GoodsDto> selectGoodsByGoodsType( String type){
        if(StringUtils.isEmpty(type)) {
            return new Message().setCode(401).setMessage("商品类型为空");
        }
        List<GoodsDto> goods = service.selectGoodsByGoodsType(type);

        return new Message().setCode(200).setData(goods).setMessage("这个商品要么折扣要么满减");
    }

}
