package com.jxd.order.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.order.model.OrderFood;
import com.jxd.order.service.IOrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName OrderFoodController
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/25
 * @Version 1.0
 */
@RestController
public class OrderFoodController {
    @Autowired
    private IOrderFoodService orderFoodService;

    @RequestMapping("/getOrderFoodList")
    public List<OrderFood> getOrderFoodList(Long currPage, Long limit) {
        IPage<OrderFood> page = new Page<>(currPage, limit);
        IPage<OrderFood> rePage = orderFoodService.selectByPage(page);
        List<OrderFood> records = rePage.getRecords();
        long total = rePage.getTotal();
        return records;
    }

    // @RequestMapping("/addOrderFood")
    // public String addOrderFood(OrderFood orderFood) {
    //     if (orderFoodService.insert(orderFood)) {
    //         return "success";
    //     } else {
    //         return "fail";
    //     }
    // }
}
