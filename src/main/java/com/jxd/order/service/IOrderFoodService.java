package com.jxd.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.order.model.OrderFood;

import java.util.List;

public interface IOrderFoodService {
    /**
     * 分页查询
     * @param page 分页参数
     * @return 结果列表
     */
    IPage<OrderFood> selectByPage(IPage<OrderFood> page);

    /**
     * 插入
     * @param orderFood 实体类
     * @return 是否
     */
    boolean insert(List<OrderFood> orderFood);
}

