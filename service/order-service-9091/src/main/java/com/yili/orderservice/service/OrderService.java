package com.yili.orderservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yili.common.result.Result;
import com.yili.model.entity.Orders;
import com.yili.model.vo.OrderForm;


public interface OrderService extends IService<Orders> {

    Result<Orders> add(OrderForm orderForm);
}
