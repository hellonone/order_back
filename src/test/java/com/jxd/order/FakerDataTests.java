package com.jxd.order;

import com.github.javafaker.*;
import com.github.javafaker.Number;
import com.jxd.order.dao.EmpMapper;
import com.jxd.order.model.Emp;
import com.jxd.order.service.IEmpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

/**
 * @ClassName FakerDataTests
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/24
 * @Version 1.0
 */
@SpringBootTest
public class FakerDataTests {

    @Autowired
    private IEmpService empService;
    @Autowired
    private EmpMapper mapper;
    private final Faker faker = new Faker(Locale.SIMPLIFIED_CHINESE);

    @Test
    public void addFoodTest(){
        Food food = faker.food();
        System.out.println(food.ingredient());
    }
    @Test
    public void addEmpFaker() {
        Name name = faker.name();
        System.out.println(name.name());
        // PhoneNumber phoneNumber = faker.phoneNumber();
        // Number number = faker.number();
        // List<Emp> list = new ArrayList<>();
        // for (int i = 0; i < 45; i++) {
        //     Emp emp = new Emp();
        //     emp.setEname(name.name());
        //     emp.setTel(phoneNumber.cellPhone());
        //     emp.setSex(number.numberBetween(1, 3));
        //     emp.setJob(number.numberBetween(1, 3));
        //     emp.setDeptno(number.numberBetween(1, 7));
        //     list.add(emp);
        //     mapper.insert(emp);
        // }
    }
}
