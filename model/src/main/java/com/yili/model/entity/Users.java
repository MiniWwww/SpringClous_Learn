package com.yili.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {

    @TableId( type = IdType.AUTO)
    private Integer Id;

    private String username;

    private String password;

    private String role;

    private String email;
}
