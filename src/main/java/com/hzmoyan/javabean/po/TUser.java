package com.hzmoyan.javabean.po;

import lombok.Data;

import java.util.Date;

@Data
public class TUser {

	private Long id;
	private String userName;
	private String password;
	private String role;
	private String department;
	private Date gmtCreate;
	private Date gmtModify;
	private Date lastLoginTime;

}
