package com.yili.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginForm implements Serializable {
    private String username;

    private String password;
}
