package com.hzmoyan.dao;

import com.hzmoyan.javabean.po.TUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by wuchaooooo on 06/04/2017.
 */
@Repository
public class UserDAO {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private Map<String, String> entityToDbMap;

    @Resource(name="template1")
    private JdbcTemplate jdbcTemplate;

    public TUser getUser(String userName) {
        String sql = "select * from " + getTable() + " where `userName` = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{userName}, new BeanPropertyRowMapper<>(TUser.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public TUser getUser(long userId) {
        String sql = "select * from " + getTable() + " where `id` = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(TUser.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public TUser getUser(String userName, String password) {
        String sql = "select * from " + getTable() + " where `userName` = ? and `password` = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{userName, password}, new BeanPropertyRowMapper<>(TUser.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int updatePwd(TUser tUser){
        String sql = "update "+getTable()+" set password=?,gmtModify=? where id=?";
        return jdbcTemplate.update(sql, new Object[]{tUser.getPassword(),tUser.getGmtModify(),tUser.getId()});
    }

    private String getTable() {
        return "t_user";
    }
}
