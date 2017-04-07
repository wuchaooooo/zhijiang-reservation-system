package com.hzmoyan.service;

import com.hzmoyan.dao.PlaceDAO;
import com.hzmoyan.javabean.po.TPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuchaooooo on 07/04/2017.
 */
@Service
public class PlaceService {
    @Autowired
    private PlaceDAO placeDAO;

    public List<TPlace> listPlace() {
        return placeDAO.listPlace();
    }
}
