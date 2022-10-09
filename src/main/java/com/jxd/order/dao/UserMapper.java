package com.jxd.order.dao;

import com.jxd.order.model.User;
import com.jxd.order.vo.EmpUserDeptVO;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    EmpUserDeptVO selectByNameAndPwd(@Param("username") String username, @Param("password") String password);

    boolean insert(User user);

    User selectByEmpno(Integer empno);
}
