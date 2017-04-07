package com.hzmoyan.javabean.po;

import lombok.Data;

import java.util.Date;

@Data
public class TUser {

	private long id;
	private String userName;
	private String password;
	private String role;
	private Date gmtCreate;
	private Date gmtModify;
	private Date lastLoginTime;

}
