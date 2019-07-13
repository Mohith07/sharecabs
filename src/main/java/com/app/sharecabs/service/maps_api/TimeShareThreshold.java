package com.app.sharecabs.service.maps_api;

public enum TimeShareThreshold {
    DEFAULT(10),
    HIGH(20),
    VERY_HIGH(30);


    private int value;

    TimeShareThreshold(int inVal) {
        this.value = inVal;
    }

    public int getValue() {
        return this.value;
    }
}
