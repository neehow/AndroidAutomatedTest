package com.liepin.execption;

public class NoSuchElementException extends NotFoundException {

    private static final long serialVersionUID = 1L;

    public NoSuchElementException(String reason) {
        super(reason);
    }

    public NoSuchElementException(String reason, Throwable cause) {
        super(reason, cause);
    }

    @Override
    public String getSupportUrl() {
        return "http://www.liepin.com";
    }

}
