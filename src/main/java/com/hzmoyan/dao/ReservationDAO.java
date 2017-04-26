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

    public List<TReservation> listReservationByDepartmentPrincipal(String department) {
        String sql = "select * from " + getTable() + " where `placeDepartment` = '" + department + "' and `check1` = 0";
        RowMapper<TReservation> rowMapper = new BeanPropertyRowMapper<>(TReservation.class);
        try {
            return jdbcTemplate.query(sql, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<TReservation> listReservationByDepartmentLeader(String department) {
        String sql = "select * from " + getTable() + " where `placeDepartment` = '" + department + "' and `check1` = 1 and `check2` = 0";
        RowMapper<TReservation> rowMapper = new BeanPropertyRowMapper<>(TReservation.class);
        try {
            return jdbcTemplate.query(sql, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //查看指定场馆指定时间段内是否已经被预约, 返回false表示时间冲突，返回true表示时间不冲突。
    public boolean checkDateTime(String startTime, String endTime, String placeName) {
        String sql = "select * from " + getTable() + " where `placeName` = '" + placeName + "' and ((`startTime` between '" + startTime + "' and '" + endTime + "') or (`endTime` between '" + startTime + "' and '" + endTime + "') or ('" + startTime + "' between `startTime` and `endTime`) or ('" + endTime + "' between `startTime` and `endTime`))";
        RowMapper<TReservation> rowMapper = new BeanPropertyRowMapper<>(TReservation.class);
        try {
            List<TReservation> tReservationList = jdbcTemplate.query(sql, rowMapper);
            int size = tReservationList.size();
            if (size == 0) {
                //不冲突
                return true;
            }
            //冲突
            return false;
        } catch (EmptyResultDataAccessException e) {
            //不冲突
            return true;
        }
    }

    public int saveReservation(TReservation tReservation) {
        String sql = "insert into " + getTable() + " (`placeName`, `placeDepartment`, `title`, `startTime`, `endTime`, `applicant`, `userName`, `mobile`, `gmtCreate`) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{tReservation.getPlaceName(), tReservation.getPlaceDepartment(), tReservation.getTitle(), tReservation.getStartTime(), tReservation.getEndTime(), tReservation.getApplicant(), tReservation.getUserName(), tReservation.getMobile(), tReservation.getGmtCreate()});
    }

    private String getTable() {
        return "t_reservation";
    }
}
