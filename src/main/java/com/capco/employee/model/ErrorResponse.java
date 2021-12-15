package com.capco.employee.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * In Case of Found any error in any execution
 * */
@RequiredArgsConstructor
@Data
@Builder
public class ErrorResponse
{
    /**
     * Employee Id
     * */
    private final String id;
    /**
     * Enum Class For Error Code
     * */
    private final ErrorCode errorCode;
    /**
     * Reason of found Error
     * */
    private final String errorMessage;
    /**
     * Request API Time.
     * */
    private final LocalDateTime errorOccurredAt;
}
