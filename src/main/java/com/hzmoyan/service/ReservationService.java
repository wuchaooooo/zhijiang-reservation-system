package com.hzmoyan.service;

import com.hzmoyan.dao.PlaceDAO;
import com.hzmoyan.dao.ReservationDAO;
import com.hzmoyan.javabean.po.TPlace;
import com.hzmoyan.javabean.po.TReservation;
import com.hzmoyan.javabean.po.TUser;
import com.hzmoyan.javabean.vo.VReservation;
import com.hzmoyan.javabean.vo.VReservation2FullCalendar;
import com.hzmoyan.utils.AuthUtils;
import com.hzmoyan.utils.BeanUtils;
import com.hzmoyan.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wuchaooooo on 25/04/2017.
 */
@Service
public class ReservationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);

    @Autowired
    private ReservationDAO reservationDAO;
    @Autowired
    private PlaceDAO placeDAO;

    public List<VReservation2FullCalendar> listReservation(String placeName) {
        List<TReservation> tReservationList = reservationDAO.listReservation(placeName);
        return copyTReservations2VReservation2FullCalendars(tReservationList);
    }

    public List<VReservation> listReservationToCheck() {
        TUser tUser = AuthUtils.getAuthUser();
        String role = tUser.getRole();
        String department = tUser.getDepartment();
        if (role.equals("departmentPrincipal")) {
            //1级审核
            List<TReservation> tReservationList = reservationDAO.listReservationByDepartmentPrincipal(department);
            List<VReservation> vReservationList = copyTReservations2VReservations(tReservationList);
            return vReservationList;
        } else if (role.equals("departmentLeader")) {
            //2级审核
            List<TReservation> tReservationList = reservationDAO.listReservationByDepartmentLeader(department);
            List<VReservation> vReservationList = copyTReservations2VReservations(tReservationList);
            return vReservationList;
        }
        return null;
    }

    //true表示时间不冲突，false表示时间冲突
    public boolean checkDateTime(String startTime, String endTime, String placeName) {
//        String startTimeStr = DateUtils.getDateString(startTime, "yyyy-MM-dd HH-mm-ss");
//        String endTimeStr = DateUtils.getDateString(endTime, "yyyy-MM-dd HH-mm-ss");
        return reservationDAO.checkDateTime(startTime, endTime, placeName);
    }

    public int saveReservation(VReservation vReservation) {
        TReservation tReservation = new TReservation();
        BeanUtils.copyPropertiesIgnoreNull(vReservation, tReservation);
        tReservation.setGmtCreate(new Date());
        TPlace tPlace = placeDAO.getPlace(vReservation.getPlaceName());
        tReservation.setPlaceDepartment(tPlace.getDepartment());
        tReservation.setStartTime(DateUtils.getDateFromString(vReservation.getStartTime(), "yyyy-MM-dd HH:mm"));
        tReservation.setEndTime(DateUtils.getDateFromString(vReservation.getEndTime(), "yyyy-MM-dd HH:mm"));
        return reservationDAO.saveReservation(tReservation);
    }

    private List<VReservation> copyTReservations2VReservations(List<TReservation> tReservationList) {
        if (tReservationList == null) {
            return null;
        }
        List<VReservation> vReservationList = new ArrayList<>();
        for (TReservation tReservation : tReservationList) {
            VReservation vReservation = new VReservation();
            BeanUtils.copyPropertiesIgnoreNull(tReservation, vReservation);
            String startTimeStr = DateUtils.getDateString(tReservation.getStartTime(), "yyyy-MM-dd HH:mm");
            String endTimeStr = DateUtils.getDateString(tReservation.getEndTime(), "yyyy-MM-dd HH:mm");
            vReservation.setStartTime(startTimeStr);
            vReservation.setEndTime(endTimeStr);
            vReservationList.add(vReservation);
        }
        return vReservationList;
    }

    private List<VReservation2FullCalendar> copyTReservations2VReservation2FullCalendars(List<TReservation> tReservationList) {
        if (tReservationList == null) {
            return null;
        }
        List<VReservation2FullCalendar> vReservationList = new ArrayList<>();
        for (TReservation tReservation : tReservationList) {
            VReservation2FullCalendar vReservation = new VReservation2FullCalendar();
            vReservation.setId(tReservation.getId());
            vReservation.setTitle(tReservation.getTitle());
            vReservation.setStart(DateUtils.getDateString(tReservation.getStartTime(), "yyyy-MM-dd HH:mm:ss"));
            vReservation.setEnd(DateUtils.getDateString(tReservation.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
            vReservation.setUrl("/reservations/" + tReservation.getId());
            vReservationList.add(vReservation);
        }
        return vReservationList;
    }

}
