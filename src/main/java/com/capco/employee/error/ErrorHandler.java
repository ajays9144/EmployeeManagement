package com.capco.employee.error;

import com.capco.employee.model.ErrorCode;
import com.capco.employee.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * 'Error Handler' handle any exception throw at global level
 * */
@Slf4j
@ControllerAdvice
public class ErrorHandler
{
    /**
     * Handle Exception within method and mapped to different Class Object.
     * */
    @ExceptionHandler({IdNotFoundException.class})
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleEmployeeNotFoundException(IdNotFoundException exception) {
        return logErrorAndRespond(ErrorCode.EMPLOYEE_NOT_FOUND, exception.getMessage());
    }

    /**
     * Mapped Error as 'Error Response' Object Class
     * */
    private ErrorResponse logErrorAndRespond(ErrorCode errorCode, String errorMessage) {
        ErrorResponse errorResponse = new ErrorResponse(UUID.randomUUID().toString(), errorCode, errorMessage, LocalDateTime.now());
        String logMessage = "Request failed at %s with following error %s";
        log.error(String.format(logMessage, LocalDateTime.now(), errorResponse.toString()));
        return errorResponse;
    }
}
