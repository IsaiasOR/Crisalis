package com.Bootcamp.Crisalis.enums;

public enum ActiveService {
    YES(0),
    NO(1);

    private final int number;

    ActiveService(int number) {
        this.number = number;
    }

    public int number() {
        return number;
    }
}
