package com.hzmoyan.javabean.po;

import lombok.Data;

import java.util.Date;

/**
 * Created by wuchaooooo on 11/04/2017.
 */
@Data
public class TLog {
    private Long id;
    private String level;
    private String userName;
    private String type;
    private String desc;
    private Date gmtCreate;
    private String ipAddress;
}
