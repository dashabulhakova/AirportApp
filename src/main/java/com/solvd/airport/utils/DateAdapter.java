package com.solvd.airport.utils;

import org.apache.log4j.Logger;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {
    private static final Logger LOGGER = Logger.getLogger(DateAdapter.class.getName());
    @Override
    public Date unmarshal(String s) {
        try {
            return new SimpleDateFormat( "yyyy-MM-dd").parse(s);
        } catch (ParseException e) {
            LOGGER.error("Can't parse the date");
        } throw new RuntimeException();
    }
    @Override
    public String marshal(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
