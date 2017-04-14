package com.hzmoyan.dao;

import com.hzmoyan.javabean.po.TLog;
import com.hzmoyan.javabean.po.TPlace;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wuchaooooo on 11/04/2017.
 */
@Repository
public class LogDAO {

    @Resource(name="template1")
    private JdbcTemplate jdbcTemplate;

    public int saveLog(TLog tLog) {
        String sql = "insert into " + getTable() + "(`level`, `userName`, `type`, `desc`, `gmtCreate`, `ipAddress`) values(?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, tLog.getLevel(), tLog.getUserName(), tLog.getType(), tLog.getDesc(), tLog.getGmtCreate(), tLog.getIpAddress());
    }

    public List<TLog> listLog(Date beforeDate, Date endDate) {
        String sql = "select * from " + getTable() + " where `gmtCreate` between ? and ? order by `gmtCreate` desc";
        RowMapper<TLog> rowMapper = new BeanPropertyRowMapper<>(TLog.class);
        try {
            return jdbcTemplate.query(sql, rowMapper, beforeDate, endDate);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private String getTable() {
        return "t_log";
    }

}
