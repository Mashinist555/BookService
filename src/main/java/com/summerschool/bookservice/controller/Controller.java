package com.summerschool.bookservice.controller;

import com.summerschool.bookservice.service.ReportService;
import com.summerschool.bookservice.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Controller {
    
    @Autowired
    private ReportService reportService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/report/{date}")
    public ResponseEntity reportBooks(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        reportService.reportTakenBooks(date);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new Response(HttpStatus.OK.value(), "Report request is successfully sent"));
    }
    
}
