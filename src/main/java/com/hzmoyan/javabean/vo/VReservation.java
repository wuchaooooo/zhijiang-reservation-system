package com.hzmoyan.javabean.vo;

import lombok.Data;

import java.util.Date;

/**
 * Created by wuchaooooo on 25/04/2017.
 * 该类结合fullCalendar的使用手册创建
 */
@Data
public class VReservation {
    private Long id;
    private String title;
    private boolean allDay = false;
    private String start;
    private String end;
    private String url;
}
