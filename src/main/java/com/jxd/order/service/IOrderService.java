package com.jxd.order.service;

import com.jxd.order.dto.OrderAddDTO;
import com.jxd.order.dto.OrderQueryDTO;

import java.util.List;
import java.util.Map;

public interface IOrderService {
    /**
     * 新增
     * @param orderAddDTO@return 是否成功
     */
    boolean saveOrder(OrderAddDTO orderAddDTO);

    /**
     * 分页查找订单
     * @return 订单
     */
    Map<String, Object> getListPage(OrderQueryDTO queryDTO);

    boolean updateStatus(List<Integer> ordernos, Integer status);
}
