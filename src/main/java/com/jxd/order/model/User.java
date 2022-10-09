package com.jxd.order.model;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/24
 * @Version 1.0
 */
@Data
public class User {
    private Integer userno;
    private String username;
    private String password;
    private Integer empno;
    private Integer access;
}
