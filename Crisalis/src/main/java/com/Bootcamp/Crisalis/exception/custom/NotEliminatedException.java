package com.Bootcamp.Crisalis.exception.custom;

public class NotEliminatedException extends RuntimeException {

    private static final String DESCRIPTION = "Error in eliminated (400)";

    public NotEliminatedException(String detail) {
        super(DESCRIPTION.concat(". ").concat(detail));
    }
}
