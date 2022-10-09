package com.jxd.order.controller;

import com.jxd.order.model.Food;
import com.jxd.order.service.IFoodService;
import com.jxd.order.vo.FoodOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName FoodController
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/25
 * @Version 1.0
 */
@RestController
public class FoodController {
    @Autowired
    private IFoodService foodService;

    @RequestMapping("/getFoodList")
    public List<Food> getFoodList() {
        return foodService.getList();
    }

    @RequestMapping("/addFood")
    public String addFood(@RequestBody Food food) {
        if (foodService.save(food)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/getFoodGroup")
    public Map<Integer, List<FoodOrderVO>> getFoodGroup(@RequestBody List<Integer> ordernos) {
        List<FoodOrderVO> foodGroup = foodService.getFoodGroup(ordernos);
        return foodGroup.stream().collect(Collectors.groupingBy(FoodOrderVO::getFoodno));
    }

    @RequestMapping("/deleteFood")
    public String deleteFood(@RequestBody List<Integer> foodnos) {
        if (foodService.deleteFoodByBatch(foodnos)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/updateFood")
    public String updateFood(@RequestBody Food food) {
        if (foodService.updateFood(food)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/getFoodById")
    public Food getFoodById(Integer foodno) {
        return foodService.getFoodById(foodno);
    }
}
