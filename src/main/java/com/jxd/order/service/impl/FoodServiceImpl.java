package com.jxd.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.order.dao.FoodMapper;
import com.jxd.order.model.Food;
import com.jxd.order.service.IFoodService;
import com.jxd.order.vo.FoodOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName FoodServiceImpl
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/25
 * @Version 1.0
 */
@Service
public class FoodServiceImpl implements IFoodService {
    @Autowired
    private FoodMapper foodMapper;

    /**
     * 分页查询食物
     * @param page 分页
     * @return 结果
     */
    @Override
    public IPage<Food> getByPage(IPage<Food> page) {
        return foodMapper.selectByPage(page);
    }

    @Override
    public List<Food> getList() {
        return foodMapper.selectList();
    }

    /**
     * 新增食物
     * @param food 食物对象
     * @return 是否成功
     */
    @Override
    public boolean save(Food food) {
        return foodMapper.insert(food);
    }

    @Override
    public List<FoodOrderVO> getFoodGroup(List<Integer> ordernos) {
        return foodMapper.selectGroup(ordernos);
    }

    @Override
    public boolean updateFood(Food food) {
        return foodMapper.update(food);
    }

    @Override
    public boolean deleteFoodByBatch(List<Integer> foodnos) {
        return foodMapper.deleteBatch(foodnos);
    }

    @Override
    public Food getFoodById(Integer foodno) {
        return foodMapper.selectById(foodno);
    }
}
