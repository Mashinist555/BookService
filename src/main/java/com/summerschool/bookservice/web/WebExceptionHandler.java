package com.summerschool.bookservice.web;

import com.summerschool.bookservice.service.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@ControllerAdvice
public class WebExceptionHandler extends ExceptionHandlerExceptionResolver {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseEntity<Response> handleServiceException(final ServiceException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new Response(HttpStatus.BAD_REQUEST.value(), ex.getMessage())
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity<Response> handleDataIntegrityViolationException(final DataIntegrityViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new Response(HttpStatus.BAD_REQUEST.value(), "Bad request")
        );
    }

    @ExceptionHandler(CannotCreateTransactionException.class)
    @ResponseBody
    public ResponseEntity<Response> handleCannotCreateTransactionException(final CannotCreateTransactionException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(
                new Response(HttpStatus.SERVICE_UNAVAILABLE.value(), "No connection with database")
        );
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public ResponseEntity<Response> handleCannotCreateTransactionException(final DataAccessException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(
                new Response(HttpStatus.SERVICE_UNAVAILABLE.value(), "Problem with data access")
        );
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseEntity<Response> handleAll(final Throwable exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "oops... Internal server error")
        );
    }
}
