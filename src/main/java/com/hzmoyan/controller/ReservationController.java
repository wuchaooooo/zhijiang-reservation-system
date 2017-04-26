package com.hzmoyan.controller;

import com.hzmoyan.javabean.AjaxRequestResult;
import com.hzmoyan.javabean.vo.VReservation;
import com.hzmoyan.javabean.vo.VReservation2FullCalendar;
import com.hzmoyan.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return "reservation-calendar/reservation-info";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<VReservation2FullCalendar> getReservation(
            @RequestParam(value = "placename") String placeName,
            Map<String, Object> model) {
        List<VReservation2FullCalendar> vReservationList =  reservationService.listReservation(placeName);
        model.put("placeName", placeName);
        return vReservationList;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public AjaxRequestResult saveReservation(
            @ModelAttribute VReservation vReservation) {
        AjaxRequestResult ajaxRequestResult = new AjaxRequestResult();
        boolean checkDateTime = reservationService.checkDateTime(vReservation.getStartTime(), vReservation.getEndTime(), vReservation.getPlaceName());
        if (!checkDateTime) {
            //预约时间和数据库冲突，预约失败
            ajaxRequestResult.setSuccess(false);
            ajaxRequestResult.setErrorMsg("该预约时间存在冲突，请查看场地预约情况后重新预约");
            return ajaxRequestResult;
        }
        reservationService.saveReservation(vReservation);
        ajaxRequestResult.setSuccess(true);
        ajaxRequestResult.setSuccessMsg("预约成功，可以到\"我的申请\"中查看预约详情");
        return ajaxRequestResult;
    }

    @RequestMapping(value = "/checks", method = RequestMethod.GET)
    public String listCheck(
            Map<String, Object> model) {
        List<VReservation> reservationList = reservationService.listReservationToCheck();
        model.put("reservationList", reservationList);
        return "reservation-calendar/reservation-check";
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public String getModel(
            @RequestParam("placename") String placeName,
            Map<String, Object> model) {
        model.put("placeName", placeName);
        return "reservation-calendar/reservation-model";
    }
}
