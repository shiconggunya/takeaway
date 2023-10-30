package com.apply.reggie.dto;


import com.apply.reggie.entity.OrderDetail;
import lombok.Data;
import java.util.List;

@Data
public class OrdersDto {

    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;
	
}
