package com.hzmoyan.service;

import com.hzmoyan.dao.LogDAO;
import com.hzmoyan.javabean.po.TLog;
import com.hzmoyan.javabean.vo.VLog;
import com.hzmoyan.utils.AuthUtils;
import com.hzmoyan.utils.BeanUtils;
import com.hzmoyan.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wuchaooooo on 11/04/2017.
 */
@Service
public class LogService {
    @Autowired
    private LogDAO logDAO;

    public int saveLog(String level, String type, String desc, String ipAddress) {
        TLog tLog = new TLog();
        tLog.setLevel(level);
        tLog.setUserName(AuthUtils.getAuthUser().getUserName());
        tLog.setType(type);
        tLog.setDesc(desc);
        tLog.setIpAddress(ipAddress);
        tLog.setGmtCreate(DateUtils.getCurrentTime());
        return logDAO.saveLog(tLog);
    }

    public List<VLog> listLog() {
        Date nowDate = DateUtils.getCurrentTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        //一个月前的时间
        calendar.add(2, -1);
        Date beforeDate = calendar.getTime();
        List<TLog> tLogList = logDAO.listLog(beforeDate, nowDate);
        return copyTLog2Vlog(tLogList);
    }

    private List<VLog> copyTLog2Vlog(List<TLog> tLogList) {
        if (tLogList == null) {
            return null;
        }
        List<VLog> vLogList = new ArrayList<>();
        for (TLog tLog : tLogList) {
            VLog vLog = new VLog();
            BeanUtils.copyPropertiesIgnoreNull(tLog, vLog);
            vLogList.add(vLog);
        }
        return vLogList;
    }

}
