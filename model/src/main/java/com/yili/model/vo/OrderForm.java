package com.yili.model.vo;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderForm {
    private int productId;
    private int quantity;
    private String email;
    private String username;
    private double price;
}
