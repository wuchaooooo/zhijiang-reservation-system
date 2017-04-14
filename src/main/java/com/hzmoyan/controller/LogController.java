package com.hzmoyan.controller;

import com.hzmoyan.javabean.po.TUser;
import com.hzmoyan.javabean.vo.VLog;
import com.hzmoyan.service.LogService;
import com.hzmoyan.utils.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by wuchaooooo on 07/04/2017.
 */
@Controller
@RequestMapping(value = "/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping(value = "")
    public String listLog(Map<String, Object> model) {
        List<VLog> logList = logService.listLog();
        model.put("logList", logList);
        return "/log/logs";
    }
}
