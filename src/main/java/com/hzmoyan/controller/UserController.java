package com.hzmoyan.controller;

import com.hzmoyan.javabean.AjaxRequestResult;
import com.hzmoyan.javabean.po.TUser;
import com.hzmoyan.javabean.vo.VUser;
import com.hzmoyan.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by wuchaooooo on 11/04/2017.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "")
    public String listUser(Map<String, Object> model) {
        List<TUser> userList = userService.listUser();
        model.put("userList", userList);
        return "/basic/user-info";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUser(
            @PathVariable(value = "userId") long id,
            @RequestParam(value = "modifypwd", required = false) String flag,
            Map<String, Object> model) {
        if (id != 0) {
            //修改用户基本信息（除密码外）
            TUser user = userService.getUser(id);
            model.put("user", user);
            if (flag != null) {
                //修改用户密码
                model.put("onlyPassword", "true");
            }
        } else if (id == 0) {
            //新增用户
            model.put("hasPassword", "true");
        }
        return "basic/user-info-model";
    }

    @RequestMapping(value = "/{userId}", method = {RequestMethod.PUT, RequestMethod.POST})
    @ResponseBody
    public AjaxRequestResult updateOrSaveUser(
            @PathVariable("userId") long id,
            @ModelAttribute VUser vUser) {
        AjaxRequestResult ajaxRequestResult = new AjaxRequestResult();
        if (id != 0) {
            vUser.setId(id);
            userService.updateUser(vUser);
            ajaxRequestResult.setSuccess(true);
            ajaxRequestResult.setSuccessMsg("更新用户信息成功");
        } else {
            int flag = userService.saveUser(vUser);
            if (flag != 0) {
                ajaxRequestResult.setSuccess(true);
                ajaxRequestResult.setSuccessMsg("添加用户成功");
            } else {
                ajaxRequestResult.setSuccess(false);
                ajaxRequestResult.setErrorMsg("该用户名已存在，请更换用户名");
            }
        }
        return ajaxRequestResult;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public AjaxRequestResult removeUser(@PathVariable("userId") long id) {
        TUser tUser = userService.getUser(id);
        String userName = tUser.getUserName();
        userService.removeUser(id);
        AjaxRequestResult ajaxRequestResult = new AjaxRequestResult();
        ajaxRequestResult.setSuccess(true);
        ajaxRequestResult.setSuccessMsg("用户:" + userName + " 删除成功");
        return ajaxRequestResult;
    }

}
