package com.application.exceptions.errors;

public class ContactsError {

    private String message;

    public ContactsError() {

    }

    public ContactsError(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ContactsError{" +
                "message='" + message + '\'' +
                '}';
    }
}
