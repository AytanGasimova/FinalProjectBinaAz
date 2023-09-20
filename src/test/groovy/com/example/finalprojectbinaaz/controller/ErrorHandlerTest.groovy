package com.example.finalprojectbinaaz.controller

import com.example.finalprojectbinaaz.exception.NotFoundException
import com.example.finalprojectbinaaz.exception.ValidationException
import com.example.finalprojectbinaaz.model.ExceptionDto
import spock.lang.Specification

class ErrorHandlerTest extends Specification {
    private ErrorHandler errorHandler
    private ExceptionDto exceptionDto
    private String message


    void setup() {
        errorHandler = new ErrorHandler()
    }

    def "NOT_FOUND handler"() {
        given:
        message = "NOT_FOUND"
        def exception = new NotFoundException(message)

        when:
        exceptionDto = errorHandler.handler(exception)

        then:
        exceptionDto != null
        exceptionDto.message == message
    }

    def "INTERNAL_SERVER_ERROR handler"() {
        given:
        message = "INTERNAL_SERVER_ERROR"
        def exception = new Exception(message)

        when:
        exceptionDto = errorHandler.handler(exception)

        then:
        exceptionDto != null
        exceptionDto.message == message
    }

    def "BAD_REQUEST handler1"() {
        given:
        message = "BAD_REQUEST"
        def exception = new ValidationException(message)

        when:
        exceptionDto = errorHandler.handler(exception)

        then:
        exceptionDto != null
        exceptionDto.message == message
    }
}
