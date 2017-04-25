package com.hzmoyan.controller;

import com.hzmoyan.javabean.vo.VReservation;
import com.hzmoyan.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by wuchaooooo on 25/04/2017.
 */
@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String demo(
            @RequestParam(value = "placename") String placeName,
            Map<String, Object> model) {
        model.put("placeName", placeName);
        return "reservation-calendar/demo";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<VReservation> getReservation(
            @RequestParam(value = "placename") String placeName,
            Map<String, Object> model) {
        List<VReservation> vReservationList =  reservationService.listReservation(placeName);
        model.put("placeName", placeName);
        return vReservationList;
    }
}
