package com.jxd.order;

import com.jxd.order.dto.OrderQueryDTO;
import com.jxd.order.service.IEmpService;
import com.jxd.order.service.IFoodService;
import com.jxd.order.service.IOrderService;
import com.jxd.order.vo.FoodOrderVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName ServiceTests
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/28
 * @Version 1.0
 */
@SpringBootTest
public class ServiceTests {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IFoodService foodService;
    @Autowired
    private IEmpService empService;

    @Test
    public void testSelectAll() {
        OrderQueryDTO queryDTO = new OrderQueryDTO();
        queryDTO.setCurrPage(1L);
        queryDTO.setLimit(10L);
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 0, 0, 0);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 23, 59, 59);
        queryDTO.setTimeStart(localDateTime1.toString());
        queryDTO.setTimeEnd(localDateTime2.toString());
        Map<String, Object> listPage = orderService.getListPage(queryDTO);
        System.out.println(listPage.get("total"));
    }

    @Test
    public void testFoodGroup() {
        List<Integer> ordernos = new ArrayList<>();
        Collections.addAll(ordernos, 1001, 1002, 1003, 1011, 1010);
        List<FoodOrderVO> foodGroup = foodService.getFoodGroup(ordernos);
        Map<Integer, List<FoodOrderVO>> collect = foodGroup.stream().collect(Collectors.groupingBy(FoodOrderVO::getFoodno));
        System.out.println(collect);
    }


}
