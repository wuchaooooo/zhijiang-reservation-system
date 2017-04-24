package com.hzmoyan.javabean.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by wuchaooooo on 12/04/2017.
 */
@Data
public class VUser {
    private Long id;
    private String userName;
    private String password;
    private String role;
    private String department;
    private Date lastLoginTime;
}
