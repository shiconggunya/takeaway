package com.apply.reggie.service;

import com.apply.reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author a
* @description 针对表【orders(订单表)】的数据库操作Service
* @createDate 2023-10-29 18:41:13
*/
public interface OrdersService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);
}
