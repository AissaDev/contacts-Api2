package com.application.exceptions.advice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.application.exceptions.ContactNotFoundException;
import com.application.exceptions.errors.ContactsError;



@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String UNEXPECTED_ERROR_OCCURS = "Unexpected error occurs";

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ContactNotFoundException.class)
    @ResponseBody
    public ContactsError handleContactNotFoundException(final ContactNotFoundException exception) {
        logger.info("Handle exception:", exception);
        final ContactsError contactsError = new ContactsError(exception.getLocalizedMessage());
        logger.info("contactsError {}", contactsError);
        return contactsError;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ContactsError handleException(final Exception exception) {
        logger.info("Handle exception:", exception);
        final ContactsError contactsError = new ContactsError(String.format("%s - %s", UNEXPECTED_ERROR_OCCURS, exception.getLocalizedMessage()));
        logger.info("contactsError {}", contactsError);
        return contactsError;
    }
}
