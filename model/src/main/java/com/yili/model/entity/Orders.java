package com.yili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Orders implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private int productId;
    private int quantity;
    private double totalPrice;
    private String customerName;
    private String customerEmail;
    private Date orderDate;

}
