package com.yili.orderservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yili.common.result.Result;
import com.yili.model.entity.Orders;
import com.yili.model.vo.OrderForm;
import com.yili.orderservice.mapper.OrderMapper;
import com.yili.orderservice.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    public Result<Orders> add(OrderForm orderForm) {
        Orders orders =new Orders();
        String username = orderForm.getUsername();
        double price = orderForm.getPrice();
        int productId = orderForm.getProductId();
        String email = orderForm.getEmail();
        int quantity = orderForm.getQuantity();

        orders.setOrderDate(new Date());
        orders.setProductId(productId);
        orders.setQuantity(quantity);
        orders.setCustomerEmail(email);
        orders.setCustomerName(username);
        orders.setTotalPrice(price*quantity);

        int insert = orderMapper.insert(orders);
        if(insert>0){
            return Result.ok(null);
        }
        return Result.fail("购买失败");
    }
}
