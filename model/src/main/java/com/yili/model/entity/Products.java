package com.yili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * 商品实体类
 */

@Data
public class Products implements Serializable {
    //主键
    @TableId( type = IdType.AUTO)
    private Integer id;
    //商品名字
    private String name;
    //描述
    private String description;
    //规格
    private String specifications;
    //价钱
    private double price;
    //库存
    private int stock;
    //材质
    private String material;
    //是否上架

    private String img;
    private int isAvailable;
}
