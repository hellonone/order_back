package com.jxd.order.dto;

import com.jxd.order.model.OrderFood;
import com.jxd.order.vo.EmpTempVO;
import lombok.Data;

import java.util.List;

/**
 * @ClassName OrderAddDTO
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/30
 * @Version 1.0
 */
@Data
public class OrderAddDTO {
    private List<OrderFood> applyFood;
    private String character;
    private Integer count;
    private Integer count2;
    private Integer applyno;
    private String ename;
    private Double price;
    private List<EmpTempVO> selectedEmpList;
    private String time;
    private String note;
    private Integer type;
    private Integer deptno;
}
