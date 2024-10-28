package com.yili.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comments implements Serializable {
    private int id;
    private int productId;
    private String content;
    private String author;
    private Date createTime;

}
