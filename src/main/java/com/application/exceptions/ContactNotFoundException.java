package com.application.exceptions;

;

public class ContactNotFoundException extends ContactApiException {
    public ContactNotFoundException(String message) {
        super(message);
    }
}
