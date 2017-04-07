package com.hzmoyan.service;

import com.hzmoyan.dao.UserDAO;
import com.hzmoyan.javabean.po.TUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDAO userDAO;
    
    public TUser getUser(String userName){
    	return userDAO.getUser(userName);
    }

    public TUser getUser(long userId) {
        return userDAO.getUser(userId);
    }

    public TUser getUser(String userName, String password) {
        return userDAO.getUser(userName, password);
    }
    
}
