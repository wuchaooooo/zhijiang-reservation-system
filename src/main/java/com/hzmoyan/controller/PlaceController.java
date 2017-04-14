package com.hzmoyan.controller;

import com.hzmoyan.javabean.vo.VPlace;
import com.hzmoyan.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by wuchaooooo on 07/04/2017.
 */
@Controller
@RequestMapping(value = "/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "")
    public String listPlace(
            @RequestParam(value = "department", required = false) String department,
            Map<String, Object> model) {
        List<VPlace> placeList;
        if (department == null) {
            placeList = placeService.listPlace();
            model.put("type", "all");
        } else {
            placeList = placeService.listPlace(department);
            model.put("type", "department");
        }
        model.put("placeList", placeList);
        return "place/placeInfo";
    }
}
