package com.hzmoyan.dao;

import com.hzmoyan.javabean.po.TReservation;
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
 * Created by wuchaooooo on 25/04/2017.
 */
@Repository
public class ReservationDAO {
    private static final Logger logger = LoggerFactory.getLogger(ReservationDAO.class);

    @Resource(name="template1")
    private JdbcTemplate jdbcTemplate;

    public List<TReservation> listReservation(String placeName) {
        String sql = "select * from " + getTable() + " where `placeName` = '" + placeName + "' order by `gmtModify` desc";
        RowMapper<TReservation> rowMapper = new BeanPropertyRowMapper<>(TReservation.class);
        try {
            return jdbcTemplate.query(sql, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private String getTable() {
        return "t_reservation";
    }
}
