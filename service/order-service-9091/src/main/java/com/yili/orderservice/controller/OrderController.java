package com.yili.orderservice.controller;


import com.yili.common.result.Result;
import com.yili.model.entity.Orders;
import com.yili.model.vo.OrderForm;
import com.yili.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    OrderService orderService;


    /**
     * 查询所有订单
     * @return 返回包含订单列表的 Result 对象
     */
    @GetMapping("/list")
    public Result<List<Orders>> getOrderList() {
        List<Orders> orderList = orderService.list();
        return Result.ok(orderList);
    }

    /**
     * 删除订单
     * @param id 订单ID
     * @return 返回操作结果的 Result 对象
     */
    @DeleteMapping("/{id}")
    public Result<?> deleteOrderById(@PathVariable Integer id) {
        if (orderService.removeById(id)) {
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");

    }
    /**
     * 更新订单
     * @param order 更新后的订单对象
     * @return 返回操作结果的 Result 对象
     */
    @PutMapping("/update")
    public Result<?> updateOrder(@RequestBody Orders order) {
        if (orderService.updateById(order)) {
            return Result.ok("更新成功");
        }
        return Result.fail("更新失败");
    }

    /**
     * 查看单个订单
     * @param id 订单ID
     * @return 返回包含订单信息的 Result 对象
     */
    @GetMapping("/{id}")
    public Result<Orders> getOrderById(@PathVariable Integer id) {
        Orders order = orderService.getById(id);
        return Result.ok(order);
    }

    /**
     *  添加订单
     * @param orderForm 订单
     * @return Result 对象
     */
    @PostMapping("/add")
    public Result<Orders> add(@RequestBody OrderForm orderForm) {
        System.out.println(orderForm);
        return orderService.add(orderForm);
    }




}
