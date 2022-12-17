package com.Bootcamp.Crisalis.exception.custom;

public class UnauthorizedException extends RuntimeException{

    private static final String DESCRIPTION = "Credentials invalid (401)";

    public UnauthorizedException(String detail) {
        super(DESCRIPTION.concat(". ").concat(detail));
    }
}
