package com.jxd.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.order.dao.OrderFoodMapper;
import com.jxd.order.model.OrderFood;
import com.jxd.order.service.IOrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderFoodServiceImpl
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/25
 * @Version 1.0
 */
@Service
public class OrderFoodServiceImpl implements IOrderFoodService {
    @Autowired
    private OrderFoodMapper orderFoodMapper;

    /**
     * 分页查询
     * @param page 分页参数
     * @return 结果列表
     */
    @Override
    public IPage<OrderFood> selectByPage(IPage<OrderFood> page) {
        return orderFoodMapper.selectByPage(page);
    }

    /**
     * 插入
     * @param orderFood 实体类
     * @return 是否
     */
    @Override
    public boolean insert(List<OrderFood> orderFood) {
        return orderFoodMapper.insert(orderFood);
    }
}
