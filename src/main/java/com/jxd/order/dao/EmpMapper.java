package com.jxd.order.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.order.model.Dept;
import com.jxd.order.model.Emp;
import com.jxd.order.vo.EmpTempVO;
import com.jxd.order.vo.EmpUserDeptVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpMapper {


    /**
     * @param ename  员工姓名
     * @param deptno 员工编号
     * @return 列表
     */
    List<EmpUserDeptVO> selectByDeptOrName(@Param("ename") String ename, @Param("deptno") Integer deptno);

    List<EmpTempVO> selectByOrdernos(List<Integer> ordernos);

    EmpUserDeptVO selectByEmpno(Integer empno);

    List<Emp> selectEmpByDeptno(Integer deptno);

    IPage<EmpTempVO> selectAllBySearch(IPage<EmpTempVO> page, @Param("map") Map<String, String> map);

    boolean updateById(Emp emp);

    boolean deleteBatch(List<Integer> empnos);

    boolean insert(Emp emp);

    List<Dept> selectAllDept();

    Emp selectEmpByEmpno(Integer empno);
}
