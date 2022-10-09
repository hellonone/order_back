package com.jxd.order.dao;

import com.jxd.order.model.EmpOrder;

import java.util.List;

public interface EmpOrderMapper {
    boolean insert(List<EmpOrder> empOrders);
}
