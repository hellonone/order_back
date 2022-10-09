package com.jxd.order;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderApplicationTests {

    @Test
    void contextLoads() {
    }


    // 分页使用 
/*     @Test
    public void testPage() {
        // 利用page和limit构造Page对象
        IPage<Map<String, Object>> page = new Page<>(1, 5);
        // 底层执行分页查询，返回page对象
        IPage<Map<String, Object>> pageResult = empService.getEmpWithDept(page);
        List<Map<String, Object>> list = pageResult.getRecords();
        long count = pageResult.getTotal();
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
        // 从pageResult中获取我们需要的对象
    } */
}
