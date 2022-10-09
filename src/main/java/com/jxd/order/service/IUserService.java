package com.jxd.order.service;

import com.jxd.order.model.User;
import com.jxd.order.vo.EmpUserDeptVO;

public interface IUserService {
    /**
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    EmpUserDeptVO login(String username, String password);

    boolean register(User user);
}
