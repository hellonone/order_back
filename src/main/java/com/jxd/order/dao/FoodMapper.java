package com.jxd.order.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.order.model.Food;
import com.jxd.order.vo.FoodOrderVO;

import java.util.List;

public interface FoodMapper {
    /**
     * 分页查询食物
     * @param page 分页
     * @return 结果
     */
    IPage<Food> selectByPage(IPage<Food> page);

    List<Food> selectList();

    /**
     * 新增食物
     * @param food 食物对象
     * @return 是否成功
     */
    boolean insert(Food food);

    boolean update(Food food);

    boolean deleteBatch(List<Integer> foodnos);

    List<FoodOrderVO> selectGroup(List<Integer> ordernos);

    Food selectById(Integer foodno);
}
