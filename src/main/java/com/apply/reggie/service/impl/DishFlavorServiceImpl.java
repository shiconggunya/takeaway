package com.apply.reggie.service.impl;

import com.apply.reggie.entity.DishFlavor;
import com.apply.reggie.mapper.DishFlavorMapper;
import com.apply.reggie.service.DishFlavorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>implements DishFlavorService {
}
