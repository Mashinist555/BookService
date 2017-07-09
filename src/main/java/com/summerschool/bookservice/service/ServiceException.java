package com.summerschool.bookservice.service;

public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
