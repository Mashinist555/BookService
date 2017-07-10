package com.summerschool.bookservice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReportServiceImpl implements ReportService {
    
    @Async
    @Override
    public void reportTakenBooks(Date date) {
        //TODO get all bookings with starDate <= date and endDate >=date
        //and send an email with them using gmail account
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
