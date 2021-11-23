package me.ahmed.repos.services.impl;


import me.ahmed.repos.services.DateService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class DateServiceImpl implements DateService {

    @Override
    public String getStringDateBefore30Days(SimpleDateFormat simpleDateFormat) {
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -30);
        Date today30 = cal.getTime();
        return simpleDateFormat.format(today30);
    }
}
