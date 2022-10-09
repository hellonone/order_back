package com.jxd.order.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.order.dto.OrderQueryDTO;
import com.jxd.order.model.Order;
import com.jxd.order.vo.OrderEmpVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    /**
     * 新增
     * @param order 对象
     * @return 新增后的主键
     */
    boolean insert(Order order);

    /**
     * 分页查找订单
     * @return 订单
     */
    IPage<OrderEmpVO> selectListBySearch(@Param("page") IPage<Order> page, @Param("queryDTO") OrderQueryDTO queryDTO);

    List<OrderEmpVO> selectList(OrderQueryDTO queryDTO);

    boolean updateStatus(@Param("ordernos")List<Integer> ordernos, @Param("status") Integer status);
}
