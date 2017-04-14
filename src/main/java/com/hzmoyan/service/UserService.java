package com.hzmoyan.service;

import com.hzmoyan.dao.UserDAO;
import com.hzmoyan.javabean.po.TUser;
import com.hzmoyan.javabean.vo.VUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public TUser getUser(String userName){
    	return userDAO.getUser(userName);
    }

    public TUser getUser(long userId) {
        return userDAO.getUser(userId);
    }

    public TUser getUser(String userName, String password) {
        return userDAO.getUser(userName, password);
    }

    public List<TUser> listUser() {
        return userDAO.listUser();
    }

    public int removeUser(long id) {
        return userDAO.removeUser(id);
    }

    public int updateUser(VUser vUser) {
        TUser tUser = userDAO.getUser(vUser.getId());
        tUser.setGmtModify(new Date());
        BeanUtils.copyProperties(vUser, tUser);
        return userDAO.updateUser(tUser);
    }

    public int saveUser(VUser vUser) {
        //判断该用户名是否已存在
        TUser tUserCheck = userDAO.getUser(vUser.getUserName());
        if (tUserCheck != null) {
            return 0;
        }
        String password = passwordEncoder.encode(vUser.getPassword());
        vUser.setPassword(password);
        TUser tUser = new TUser();
        BeanUtils.copyProperties(vUser, tUser);
        tUser.setGmtCreate(new Date());
        return userDAO.saveUser(tUser);
    }
    
}
