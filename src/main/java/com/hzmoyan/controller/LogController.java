package com.hzmoyan.controller;

import com.hzmoyan.javabean.po.TUser;
import com.hzmoyan.utils.AuthUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by wuchaooooo on 07/04/2017.
 */
@Controller
@RequestMapping(value = "/logs")
public class LogController {

    @RequestMapping(value = "/system")
    public String getSystemLog(Map<String, Object> model) {
        TUser tUser = AuthUtils.getAuthUser();
        model.put("role", tUser.getRole());
        return "/log/log-system";
    }
}
