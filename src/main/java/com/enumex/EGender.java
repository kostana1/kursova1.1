package com.enumex;

public enum EGender {
    MALE(0),
    FEMALE(1);

    private final int genderValue;

    EGender(int genderValue) {
        this.genderValue = genderValue;
    }

    public int getGenderValue() {
        return genderValue;
    }
}
