package com.hzmoyan.dao;

import com.hzmoyan.javabean.po.TPlace;
import com.hzmoyan.javabean.po.TUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wuchaooooo on 07/04/2017.
 */
@Repository
public class PlaceDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceDAO.class);

    @Resource(name="template1")
    private JdbcTemplate jdbcTemplate;

    public List<TPlace> listPlace() {
        String sql = "select * from " + getTable();
        RowMapper<TPlace> rowMapper = new BeanPropertyRowMapper<>(TPlace.class);
        try {
            return jdbcTemplate.query(sql, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<TPlace> listPlace(String department) {
        String sql = "select * from " + getTable() + " where `department` = ?";
        RowMapper<TPlace> rowMapper = new BeanPropertyRowMapper<>(TPlace.class);
        try {
            return jdbcTemplate.query(sql, rowMapper, department);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public TPlace getPlace(String placeName) {
        String sql = "select * from " + getTable() + " where `placeName` = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{placeName}, new BeanPropertyRowMapper<>(TPlace.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private String getTable() {
        return "t_place";
    }

}
