package com.zingpay.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zingpay.util.Status;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Bilal Hassan on 09-Sep-2020
 * @project ZingPay
 */

@ControllerAdvice
@RequestMapping(produces = "application/json")
public class CustomException {

    private static final Logger logger = LoggerFactory.getLogger(CustomException.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Status> noSuchElementFound(final Exception e) {
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Status> httpMessageNotReadableException(final Exception e) {
        return error(e, HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(CustomFeignException.class)
    public ResponseEntity<Status> handleFeignStatusException(final CustomFeignException e) {
        return error(e, HttpStatus.BAD_GATEWAY, e.getMessage());
    }

    /*@ExceptionHandler(RetryableException.class)
    public ResponseEntity<Status> handleFeignRetryableException(final RetryableException e) {
        return error(e, HttpStatus.FAILED_DEPENDENCY, e.getMessage());
    }*/

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Status> constraintViolation(final Exception e) {
        return error(e, HttpStatus.EXPECTATION_FAILED, e.getMessage());
    }

    private ResponseEntity<Status> error(final Exception exception, HttpStatus httpStatus, final String logRef) {
        logger.error("", exception);
        String message = "";
        if (exception instanceof AccessDeniedException) {
            message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        } else if (exception instanceof NoSuchElementException) {
            message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        } else if (exception instanceof DataIntegrityViolationException) {
            httpStatus = HttpStatus.BAD_REQUEST;
            Throwable t1 = exception.getCause();
            if (t1 instanceof ConstraintViolationException) {
                ConstraintViolationException cve = (ConstraintViolationException) t1;
                Throwable t2 = cve.getCause();
                if (t2 instanceof SQLException) {
                    SQLException sic = (SQLException) t2;
                    message = createMessageForConstraintViolation(sic);
                    httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                }
            }
        } else if (exception instanceof CustomFeignException) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            try {
                Status status = new ObjectMapper().readValue(exception.getMessage(), Status.class);
                return new ResponseEntity<Status>(status, httpStatus);
            } catch (JsonProcessingException e) {
                System.out.println("error= unable to parse response from Feign Exception");
            }
        }/* else if (exception instanceof RetryableException) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            try {
                Status status = new ObjectMapper().readValue(exception.getMessage(), Status.class);
                return new ResponseEntity<Status>(status, httpStatus);
            } catch (JsonProcessingException e) {
                System.out.println("error= unable to parse response from Feign Exception");
            }
        }*/

        if (exception instanceof StatusException) {
            StatusException statusException = (StatusException)exception;

            Status status = new Status(statusException.getStatusMessage());
            logger.info("exception end=" + System.currentTimeMillis());
            return new ResponseEntity<Status>(status, httpStatus);
        }
        if (message.isEmpty()) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            message = exception.getMessage();
        }
        Status status = new Status(httpStatus.value(), message, 1L);
        logger.info("exception end=" + System.currentTimeMillis());
        return new ResponseEntity<Status>(status, httpStatus);
    }

    private String createMessageForConstraintViolation(SQLException sic) {
        String message = "Database constraint error";
        String errorMessage = sic.getMessage();
        String actualConstraintViolated = "";
        if (errorMessage.contains("duplicate") || errorMessage.contains("Duplicate")) {
            /*actualConstraintViolated = errorMessage.split("'")[1];
            if(errorMessage.contains("pin")){
                message = "PIN already exist";
            }else{
                message = "Entry with '" + actualConstraintViolated + "' already exist";
            }*/
            //actualConstraintViolated = errorMessage.split("=")[0].split("Key ")[1].split("\\(")[1].split(",")[0];
            actualConstraintViolated = errorMessage.split("=")[0].split("key ")[1];

            if (errorMessage.contains("app_user.app_user_email_uindex")) {
                message = "Email already exists";
            } else if(errorMessage.contains("app_user.app_user_cell_phone_uindex")) {
                message = "Cell Phone already exists";
            } else {
                message = actualConstraintViolated + " already exists";
            }


        } /*else {
            String[] allMsgs = errorMessage.split("REFERENCES");
            actualConstraintViolated = allMsgs[1].split("`")[1];
            //message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
            message = "Could not save data due to data constraints voilation with " + actualConstraintViolated;
        }*/
        return message;
    }

}
