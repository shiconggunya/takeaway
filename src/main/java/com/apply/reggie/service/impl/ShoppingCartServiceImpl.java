package com.apply.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.apply.reggie.entity.ShoppingCart;
import com.apply.reggie.service.ShoppingCartService;
import com.apply.reggie.mapper.ShoppingCartMapper;
import org.springframework.stereotype.Service;

/**
* @author a
* @description 针对表【shopping_cart(购物车)】的数据库操作Service实现
* @createDate 2023-10-29 13:26:22
*/
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart>
    implements ShoppingCartService{

}




