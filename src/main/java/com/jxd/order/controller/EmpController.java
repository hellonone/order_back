package com.jxd.order.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.order.model.Dept;
import com.jxd.order.model.Emp;
import com.jxd.order.service.IEmpService;
import com.jxd.order.vo.EmpTempVO;
import com.jxd.order.vo.EmpUserDeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpController
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/29
 * @Version 1.0
 */
@RestController
public class EmpController {
    @Autowired
    IEmpService empService;

    @RequestMapping("/getEmpList")
    public List<EmpUserDeptVO> getEmpList(@RequestBody Map<String, String> queryMap) {
        String ename = queryMap.get("ename");
        Integer deptno = Integer.parseInt(queryMap.get("deptno"));
        return empService.selectByDeptOrName(ename, deptno, true);
    }

    @RequestMapping("/getAllEmpList")
    public Map<String, Object> getAllEmpList(@RequestBody Map<String, String> queryMap) {
        long currPage = Long.parseLong(queryMap.get("page"));
        long limit = Long.parseLong(queryMap.get("limit"));

        IPage<EmpTempVO> iPage = new Page<>(currPage, limit);
        IPage<EmpTempVO> allEmps = empService.getAllEmps(iPage, queryMap);
        List<EmpTempVO> records = allEmps.getRecords();
        long total = allEmps.getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("data", records);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/saveEmp")
    public String saveEmp(@RequestBody Emp emp) {
        if (empService.saveEmp(emp)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(@RequestBody Emp emp) {
        if (empService.updateEmpById(emp)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/deleteEmps")
    public String deleteEmps(@RequestBody List<Integer> empnos) {
        if (empService.deleteEmpByBatch(empnos)) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping("/getDeptList")
    public List<Dept> getDeptList() {
        return empService.getAllDept();
    }

    @RequestMapping("/getEmpByEmpno")
    public Emp getEmpByEmpno(Integer empno) {
        return empService.getEmpByEmpno(empno);
    }
}
