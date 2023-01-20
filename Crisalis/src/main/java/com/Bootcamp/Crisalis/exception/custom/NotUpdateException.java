package com.Bootcamp.Crisalis.exception.custom;

public class NotUpdateException extends RuntimeException {

    private static final String DESCRIPTION = "Error in update (400)";

    public NotUpdateException(String detail) {
        super(DESCRIPTION.concat(". ").concat(detail));
    }
}
