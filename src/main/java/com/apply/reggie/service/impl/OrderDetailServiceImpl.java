package com.apply.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.apply.reggie.entity.OrderDetail;
import com.apply.reggie.service.OrderDetailService;
import com.apply.reggie.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author a
* @description 针对表【order_detail(订单明细表)】的数据库操作Service实现
* @createDate 2023-10-29 18:41:18
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
    implements OrderDetailService{

}




