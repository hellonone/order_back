package com.jxd.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.order.dao.EmpMapper;
import com.jxd.order.dao.OrderMapper;
import com.jxd.order.dto.OrderQueryDTO;
import com.jxd.order.model.Dept;
import com.jxd.order.model.Emp;
import com.jxd.order.model.Order;
import com.jxd.order.service.IEmpService;
import com.jxd.order.vo.EmpTempVO;
import com.jxd.order.vo.EmpUserDeptVO;
import com.jxd.order.vo.OrderEmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/24
 * @Version 1.0
 */
@Service
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private OrderMapper orderMapper;

    /**
     * @param ename      员工姓名
     * @param deptno     员工编号
     * @param isDistinct 是否需要去除重复员工
     * @return 列表
     */
    @Override
    @Transactional
    public List<EmpUserDeptVO> selectByDeptOrName(String ename, Integer deptno, Boolean isDistinct) {
        /* 为了代码的复用性，此代码将分为两部分，如果传入参数中有是否去重的标志，则去重 */
        if (!isDistinct) {
            return empMapper.selectByDeptOrName(ename, deptno);
        }
        /* 返回的结果是今日为订餐的员工 */
        // 拿到今日订餐的订单号，上午 13：30：00之前，下午13:30:00之后
        LocalDate localDate = LocalDate.now();
        LocalDateTime timeBan = LocalDateTime.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth(), 13, 30, 0);
        LocalDateTime currTime = LocalDateTime.now();
        OrderQueryDTO queryDTO = new OrderQueryDTO();
        queryDTO.setDeptno(deptno);
        if (currTime.isAfter(timeBan)) {
            queryDTO.setTimeStart(timeBan.toString());
        } else {
            queryDTO.setTimeEnd(timeBan.toString());
        }
        IPage<Order> page = new Page<>(0, -1);
        IPage<OrderEmpVO> orderEmpVOIPage = orderMapper.selectListBySearch(page, queryDTO);
        List<OrderEmpVO> records = orderEmpVOIPage.getRecords();
        List<Integer> ordernos = records.stream().map(OrderEmpVO::getOrderno).collect(Collectors.toList());
        // 根据订单号，拿到员工编号，在这里的员工不会返回
        List<EmpTempVO> empTempVOS = empMapper.selectByOrdernos(ordernos);
        List<Integer> empnos = empTempVOS.stream().map(EmpTempVO::getEmpno).collect(Collectors.toList());


        List<EmpUserDeptVO> empUserDeptVOS = empMapper.selectByDeptOrName(ename, deptno);
        return empUserDeptVOS.stream().filter(empUserDeptVO -> empnos.stream().noneMatch(integer -> empUserDeptVO.getEmpno().equals(integer))).collect(Collectors.toList());
    }

    @Override
    public IPage<EmpTempVO> getAllEmps(IPage<EmpTempVO> page, Map<String, String> map) {
        return empMapper.selectAllBySearch(page, map);
    }

    @Override
    public boolean updateEmpById(Emp emp) {
        return empMapper.updateById(emp);
    }

    @Override
    public boolean deleteEmpByBatch(List<Integer> empnos) {
        return empMapper.deleteBatch(empnos);
    }

    @Override
    public boolean saveEmp(Emp emp) {
        return empMapper.insert(emp);
    }

    @Override
    public List<Dept> getAllDept() {
        return empMapper.selectAllDept();
    }

    @Override
    public Emp getEmpByEmpno(Integer empno) {
        return empMapper.selectEmpByEmpno(empno);
    }
}
