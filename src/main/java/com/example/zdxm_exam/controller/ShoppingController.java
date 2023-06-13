package com.example.zdxm_exam.controller;

import com.example.zdxm_exam.common.Message;
import com.example.zdxm_exam.dto.ShoppingDto;
import com.example.zdxm_exam.service.info.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {
    @Autowired
    private ShoppingService service;
    @PostMapping("/insert")
    public Message insertShopping(Integer goodsId,Integer userId,Integer num){
        if(goodsId==null||userId==null||num==null){
            return new Message().setCode(401).setMessage("数据为空");
        }
        int insert = service.insertShopping(goodsId,userId,num);
        if(insert==0){
           return new Message().setCode(401).setMessage("没有插入数据");
        }else {
            return new Message().setCode(200).setData(insert).setMessage("插入成功");
        }
    }
    @PostMapping("/list")
     Message<ShoppingDto> listShoppingByUserId(Integer userId){
         if(userId==null){
             return new Message().setCode(401).setMessage("用户编号为空");
         }
        List<ShoppingDto> listShopping = service.listShoppingByUserId(userId);
         return new Message().setCode(200).setData(listShopping).setMessage("查询成功");
    }
}
