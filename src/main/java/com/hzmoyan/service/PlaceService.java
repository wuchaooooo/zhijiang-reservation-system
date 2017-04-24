package com.hzmoyan.service;

import com.hzmoyan.dao.PlaceDAO;
import com.hzmoyan.javabean.po.TPlace;
import com.hzmoyan.javabean.vo.VPlace;
import com.hzmoyan.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuchaooooo on 07/04/2017.
 */
@Service
public class PlaceService {
    @Autowired
    private PlaceDAO placeDAO;

    public List<VPlace> listPlace() {
        List<TPlace> tPlaceList =  placeDAO.listPlace();
        return copyTPlaces2VPlaces(tPlaceList);

    }

    public List<VPlace> listPlace(String department) {
        List<TPlace> tPlaceList = placeDAO.listPlace(department);
        return copyTPlaces2VPlaces(tPlaceList);
    }

    private List<VPlace> copyTPlaces2VPlaces(List<TPlace> tPlaceList) {
        if (tPlaceList == null) {
            return null;
        }
        List<VPlace> vPlaceList = new ArrayList<>();
        for (TPlace tPlace : tPlaceList) {
            VPlace vPlace = new VPlace();
            BeanUtils.copyPropertiesIgnoreNull(tPlace, vPlace);
            vPlaceList.add(vPlace);
        }
        return vPlaceList;
    }
}
