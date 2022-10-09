package com.jxd.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.order.dao.EmpMapper;
import com.jxd.order.dao.EmpOrderMapper;
import com.jxd.order.dao.OrderFoodMapper;
import com.jxd.order.dao.OrderMapper;
import com.jxd.order.dto.OrderAddDTO;
import com.jxd.order.dto.OrderQueryDTO;
import com.jxd.order.model.EmpOrder;
import com.jxd.order.model.Order;
import com.jxd.order.model.OrderFood;
import com.jxd.order.service.IOrderService;
import com.jxd.order.vo.EmpTempVO;
import com.jxd.order.vo.OrderEmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/25
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderFoodMapper orderFoodMapper;
    @Autowired
    private EmpOrderMapper empOrderMapper;
    @Autowired
    private EmpMapper empMapper;

    /**
     * 新增
     * @param orderAddDTO@return 是否成功
     */
    @Override
    public boolean saveOrder(OrderAddDTO orderAddDTO) {
        // 根据orderAddDTO里面的内容，封装一个order对象
        Order order = new Order();
        order.setCount(orderAddDTO.getCount());
        order.setTime(orderAddDTO.getTime());
        order.setNote(orderAddDTO.getNote());
        order.setApplyno(orderAddDTO.getApplyno());
        order.setStatus(2);
        order.setType(orderAddDTO.getType());
        order.setSum(orderAddDTO.getPrice() * orderAddDTO.getCount());
        // 新增order
        if (orderMapper.insert(order)) {
            Integer orderno = order.getOrderno();
            List<EmpTempVO> selectedEmpList = orderAddDTO.getSelectedEmpList();

            List<EmpOrder> empOrders = selectedEmpList.stream().map(empTempVO -> {
                EmpOrder empOrder = new EmpOrder();
                empOrder.setOrderno(orderno);
                empOrder.setEmpno(empTempVO.getEmpno());
                empOrder.setDeptno(empTempVO.getDeptno());
                return empOrder;
            }).collect(Collectors.toList());

            // 新增emp_order
            boolean insertEmpOrder = empOrderMapper.insert(empOrders);

            // 新增food_order
            if (insertEmpOrder) {
                List<OrderFood> applyFood = orderAddDTO.getApplyFood();
                // 无需返回值，给每个对象的orderno赋值
                List<OrderFood> orderFoods =
                        applyFood.stream().peek(orderFood -> orderFood.setOrderno(orderno))
                                .collect(Collectors.toList());

                return orderFoodMapper.insert(orderFoods);
            }
        }
        return false;
    }

    /**
     * 分页查找订单
     * @return 订单
     */
    @Override
    public Map<String, Object> getListPage(OrderQueryDTO queryDTO) {
        /* 取出queryDTO中的查询参数 */
        Long currPage = queryDTO.getCurrPage();
        Long limit = queryDTO.getLimit();
        String ename = queryDTO.getEname();

        // 封装page分页对象，如果没有接收到参数，那么page对象不起作用
        IPage<Order> page = null;
        if (currPage == null || limit == null) {
            page = new Page<>(0, -1);
        } else {
            page = new Page<>(currPage, limit);
        }

        /* 根据查询参数分页获取OrderEmpVO（订单）的结果，并且带着一个空的EmpTempVO对象 */
        IPage<OrderEmpVO> rePage = orderMapper.selectListBySearch(page, queryDTO);
        long total = rePage.getTotal();
        List<OrderEmpVO> ableOrderEmpVOS = rePage.getRecords();

        // 跟据以上查询出的结果，获取可以与员工关联的orderno
        List<Integer> ableOrdernos = ableOrderEmpVOS.stream().map(OrderEmpVO::getOrderno).collect(Collectors.toList());

        // 根据与员工关联的ordernos，查询到每个订单下的员工
        List<EmpTempVO> empTempVOS = empMapper.selectByOrdernos(ableOrdernos);
        // 循环将上面ableOrderEmpVOS里面的空的EmpTempVO赋值，赋值结果为empTempVOS里面同一个订单号的员工
        for (OrderEmpVO orderEmpVO : ableOrderEmpVOS) {
            List<EmpTempVO> collect = empTempVOS.stream()
                    .filter(empTempVO -> orderEmpVO.getOrderno().equals(empTempVO.getOrderno()))
                    .collect(Collectors.toList());
            orderEmpVO.setEmpTempVOS(collect);
        }
        // 结果集的封装与返回
        Map<String, Object> map = new HashMap<>();
        map.put("data", ableOrderEmpVOS);
        map.put("total", total);
        return map;
    }

    @Override
    public boolean updateStatus(List<Integer> ordernos, Integer status) {
        return orderMapper.updateStatus(ordernos, status);
    }
}
