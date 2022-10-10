package com.jxd.order.service.impl;

import com.jxd.order.dao.EmpMapper;
import com.jxd.order.dao.UserMapper;
import com.jxd.order.model.User;
import com.jxd.order.service.IUserService;
import com.jxd.order.vo.EmpUserDeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/24
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;

    /**
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    @Override
    public EmpUserDeptVO login(String username, String password) {
        return userMapper.selectByNameAndPwd(username, password);
    }

    @Override
    @Transactional
    public boolean register(User user) {
        Integer empno = user.getEmpno();
        if (userMapper.selectByEmpno(empno) != null) {
            return false;
        }
        EmpUserDeptVO empUserDeptVO = empMapper.selectByEmpno(empno);
        if (empUserDeptVO == null) {
            return false;
        }
        Integer job = empUserDeptVO.getJob();
        if (job == 2) {
            user.setAccess(2);
        } else {
            user.setAccess(1);
        }
        return userMapper.insert(user);
    }
}
