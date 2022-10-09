package com.jxd.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.order.model.Dept;
import com.jxd.order.model.Emp;
import com.jxd.order.vo.EmpTempVO;
import com.jxd.order.vo.EmpUserDeptVO;

import java.util.List;
import java.util.Map;

public interface IEmpService {
    /**
     * @param ename      员工姓名
     * @param deptno     员工编号
     * @param isDistinct 是否去掉重复选择
     * @return 列表
     */
    List<EmpUserDeptVO> selectByDeptOrName(String ename, Integer deptno, Boolean isDistinct);


    IPage<EmpTempVO> getAllEmps(IPage<EmpTempVO> page, Map<String, String> map);

    boolean updateEmpById(Emp emp);

    boolean deleteEmpByBatch(List<Integer> empnos);

    boolean saveEmp(Emp emp);

    List<Dept> getAllDept();

    Emp getEmpByEmpno(Integer empno);
}
