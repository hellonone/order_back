package com.jxd.order.controller;

import com.jxd.order.dto.OrderAddDTO;
import com.jxd.order.dto.OrderQueryDTO;
import com.jxd.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/25
 * @Version 1.0
 */
@RestController
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/getOrderList")
    public Map<String, Object> getOrderList(@RequestBody OrderQueryDTO queryDTO) {
        return orderService.getListPage(queryDTO);
    }

    @RequestMapping("/getOrderCount")
    public String getOrderCount(@RequestBody OrderQueryDTO queryDTO) {
        queryDTO.setCurrPage(1L);
        queryDTO.setLimit(10L);
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 0, 0, 0);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 23, 59, 59);
        queryDTO.setTimeStart(localDateTime1.toString());
        queryDTO.setTimeEnd(localDateTime2.toString());
        Map<String, Object> map = orderService.getListPage(queryDTO);
        return map.get("total").toString();
    }

    @RequestMapping("/getConfirmList")
    public Map<String, Object> getConfirmList(@RequestBody OrderQueryDTO queryDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", 1);
        return map;
    }

    @RequestMapping("/addOrder")
    public String addOrder(@RequestBody OrderAddDTO orderAddDTO) {
        // orderService.saveOrder(orderAddDTO)
        if (orderService.saveOrder(orderAddDTO)) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(@RequestBody Map<String, Object> map) {
        List<Integer> ordernos = (List<Integer>) map.get("ordernos");
        Integer status = (Integer) map.get("status");
        if (orderService.updateStatus(ordernos, status)) {
            return "success";
        }
        return "fail";
    }
}
