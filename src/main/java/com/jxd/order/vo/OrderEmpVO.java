package com.jxd.order.vo;

import com.jxd.order.model.Order;
import lombok.Data;

import java.util.List;

/**
 * @ClassName OrderEmpVO
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/28
 * @Version 1.0
 */
@Data
public class OrderEmpVO {
    private Integer orderno;
    private String time;
    private Integer applyno;
    private Integer type;
    private Integer count;
    private Double sum;
    private Integer status;
    private String note;
    private List<EmpTempVO> empTempVOS;

    public OrderEmpVO() {

    }

    public OrderEmpVO(Order order, List<EmpTempVO> empTempVOS) {
        this.orderno = order.getOrderno();
        this.time = order.getTime();
        this.type = order.getType();
        this.applyno = order.getApplyno();
        this.count = order.getCount();
        this.sum = order.getSum();
        this.status = order.getStatus();
        this.note = order.getNote();
        this.empTempVOS = empTempVOS;
    }
}
