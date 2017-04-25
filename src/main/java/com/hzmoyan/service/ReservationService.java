package com.hzmoyan.service;

import com.hzmoyan.dao.ReservationDAO;
import com.hzmoyan.javabean.po.TPlace;
import com.hzmoyan.javabean.po.TReservation;
import com.hzmoyan.javabean.vo.VPlace;
import com.hzmoyan.javabean.vo.VReservation;
import com.hzmoyan.utils.BeanUtils;
import com.hzmoyan.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuchaooooo on 25/04/2017.
 */
@Service
public class ReservationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);

    @Autowired
    private ReservationDAO reservationDAO;

    public List<VReservation> listReservation(String placeName) {
        List<TReservation> tReservationList = reservationDAO.listReservation(placeName);
        return copyTReservations2VReservations(tReservationList);
    }

    private List<VReservation> copyTReservations2VReservations(List<TReservation> tReservationList) {
        if (tReservationList == null) {
            return null;
        }
        List<VReservation> vReservationList = new ArrayList<>();
        for (TReservation tReservation : tReservationList) {
            VReservation vReservation = new VReservation();
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
