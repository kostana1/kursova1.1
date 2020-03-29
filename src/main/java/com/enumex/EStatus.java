package com.enumex;

public enum EStatus {

    SINGLE(0),
    IN_RELATIONSHIP(1),
    MARRIED(2);

    private final int statusValue;

    EStatus(int statusValue) {
        this.statusValue = statusValue;
    }

    public int getStatusValue() {
        return statusValue;
    }
}
