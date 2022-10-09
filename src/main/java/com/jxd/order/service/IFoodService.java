package com.jxd.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.order.model.Food;
import com.jxd.order.vo.FoodOrderVO;

import java.util.List;

public interface IFoodService {
    /**
     * 分页查询食物
     * @param page 分页
     * @return 结果
     */
    IPage<Food> getByPage(IPage<Food> page);

    List<Food> getList();

    /**
     * 新增食物
     * @param food 食物对象
     * @return 是否成功
     */
    boolean save(Food food);

    List<FoodOrderVO> getFoodGroup(List<Integer> ordernos);

    boolean updateFood(Food food);

    boolean deleteFoodByBatch(List<Integer> foodnos);

    Food getFoodById(Integer foodno);
}
