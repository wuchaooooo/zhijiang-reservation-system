package com.hzmoyan.javabean.po;

import lombok.Data;

import java.util.Date;

/**
 * Created by wuchaooooo on 25/04/2017.
 */
@Data
public class TReservation {
    private Long id;
    private String placeName;
    private String placeDepartment;
    private String title;
    private Date startTime;
    private Date endTime;
    private String applicant;
    private String userName;
    private String mobile;
    private Date gmtCreate;
    private Date gmtModify;
}
