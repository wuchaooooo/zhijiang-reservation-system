package com.hzmoyan.controller;

import com.hzmoyan.javabean.po.TUser;
import com.hzmoyan.service.UserService;
import com.hzmoyan.utils.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
@RequestMapping(value = "")
public class IndexController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error", required = false) String error,
			Map<String, Object> model) {
		if (error != null) {
			model.put("error", "用户名或密码错误!");
		}
		return "login";
	}

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        long userId = AuthUtils.getAuthUserId();
        TUser tUser = userService.getUser(userId);
        model.put("user", tUser);
        return "index";
    }

}
