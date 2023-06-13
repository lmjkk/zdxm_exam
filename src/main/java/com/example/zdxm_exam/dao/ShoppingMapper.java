package com.example.zdxm_exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.zdxm_exam.dto.ShoppingDto;
import com.example.zdxm_exam.pojo.Shopping;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingMapper extends BaseMapper<Shopping> {
   List<ShoppingDto> listShoppingByUserId(Integer userId);
}
