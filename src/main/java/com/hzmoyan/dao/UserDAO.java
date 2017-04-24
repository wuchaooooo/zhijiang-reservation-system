package com.hzmoyan.dao;

import com.hzmoyan.javabean.po.TPlace;
import com.hzmoyan.javabean.po.TUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by wuchaooooo on 06/04/2017.
 */
@Repository
public class UserDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAO.class);

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

    public List<TUser> listUser() {
        String sql = "select * from " + getTable() + " order by `gmtModify` desc";
        RowMapper<TUser> rowMapper = new BeanPropertyRowMapper<>(TUser.class);
        try {
            return jdbcTemplate.query(sql, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int removeUser(long id) {
        String sql = "delete from " + getTable() + " where `id` = ?";
        return jdbcTemplate.update(sql, new Object[] {id});
    }

    public int updateUser(TUser tUser) {
        if (tUser.getPassword() == null && tUser.getLastLoginTime() == null) {
            String sql = "update " + getTable() + " set `userName` = ?, `role` = ?, `department` = ?, `gmtModify` = ? where `id` = ?";
            return jdbcTemplate.update(sql, new Object[] {tUser.getUserName(), tUser.getRole(), tUser.getDepartment(), tUser.getGmtModify(), tUser.getId()});
        } else if (tUser.getLastLoginTime() != null) {
            String sql = "update " + getTable() + " set `userName` = ?, `role` = ?, `department` = ?, `gmtModify` = ?, `lastLoginTime` = ? where `id` = ?";
            return jdbcTemplate.update(sql, new Object[] {tUser.getUserName(), tUser.getRole(), tUser.getDepartment(), tUser.getGmtModify(), tUser.getLastLoginTime(), tUser.getId()});
        } else if (tUser.getPassword() != null) {
            String sql = "update " + getTable() + " set `password` = ?, `gmtModify` = ? where `id` = ?";
            return jdbcTemplate.update(sql, new Object[] {tUser.getPassword(), tUser.getGmtModify(), tUser.getId()});
        }
        return 0;
    }

    public int saveUser(TUser tUser) {
        String sql = "insert into " + getTable() + " (`userName`, `password`, `role`, `department`, `gmtCreate`) values (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{tUser.getUserName(), tUser.getPassword(), tUser.getRole(), tUser.getDepartment(), tUser.getGmtCreate()});
    }

    public int updatePwd(TUser tUser){
        String sql = "update "+getTable()+" set password=?,gmtModify=? where id=?";
        return jdbcTemplate.update(sql, new Object[]{tUser.getPassword(),tUser.getGmtModify(),tUser.getId()});
    }

    private String getTable() {
        return "t_user";
    }
}
