package com.hzmoyan.controller;

import com.hzmoyan.javabean.po.TPlace;
import com.hzmoyan.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String listPlace(Map<String, Object> model) {
        List<TPlace> placeList = placeService.listPlace();
        model.put("placeList", placeList);
        return "place/placeInfo";
    }
}
