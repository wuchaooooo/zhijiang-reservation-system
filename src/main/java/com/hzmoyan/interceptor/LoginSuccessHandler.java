package com.hzmoyan.interceptor;

import com.hzmoyan.javabean.po.TUser;
import com.hzmoyan.javabean.vo.VUser;
import com.hzmoyan.service.LogService;
import com.hzmoyan.service.UserService;
import com.hzmoyan.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Autowired
    private LogService logService;
    @Autowired
    private UserService userService;

    @Override
	public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

        TUser user = (TUser)authentication.getPrincipal();
        String userName = user.getUserName();
        String ip = getIpAddress(request);
        String path = request.getContextPath() ;
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

        LOGGER.info("login success. userName: {}, ip: {}, time:{}", userName, ip, DateUtils.getCurrentTime());
        logService.saveLog("system", "login", "登录成功", ip);

        //将本次登录时间存入数据库t_user表中
        VUser vUser = new VUser();
        vUser.setUserName(userName);
        vUser.setLastLoginTime(DateUtils.getCurrentTime());
        userService.updateUser(vUser);

        response.sendRedirect(basePath + "index");
        return;
              
//        super.onAuthenticationSuccess(request, response, authentication);
    }  
    
    public String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("Proxy-Client-IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("WL-Proxy-Client-IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("HTTP_CLIENT_IP");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");    
        }    
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
            ip = request.getRemoteAddr();    
        }    
        return ip;    
    }  
      
}

