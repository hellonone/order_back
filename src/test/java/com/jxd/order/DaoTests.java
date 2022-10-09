package com.jxd.order;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.order.dao.EmpMapper;
import com.jxd.order.dao.OrderMapper;
import com.jxd.order.dao.UserMapper;
import com.jxd.order.model.Order;
import com.jxd.order.vo.OrderEmpVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName DaoTests
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/24
 * @Version 1.0
 */
@SpringBootTest
public class DaoTests {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    // @Test
    // public void test1() {
    //     String username = "admin";
    //     String password = "123";
    //     User user = userMapper.selectByNameAndPwd(username, password);
    //     System.out.println(user);
    // }

    @Test
    public void testSelectOrder() {
        IPage<OrderEmpVO> page = new Page<>(1, 5);
        // IPage<OrderEmpVO> iPage = orderMapper.selectListBySearch(page);
        // System.out.println(iPage.getRecords());
    }

    @Test
    public void testInsertOrder(){
        Order order = new Order();
        orderMapper.insert(order);
        System.out.println(order.getOrderno());
    }

    @Test
    public void testEmp(){
        System.out.println(empMapper.selectByEmpno(1003));
    }
}
