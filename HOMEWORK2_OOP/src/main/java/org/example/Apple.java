package org.example;

import java.util.List;

public abstract class Apple extends Phone {
    public Apple() {
        this.IMEI = "Default";
        this.batteryLife = 48;
        this.color = "White";
        this.material = "Plastic";
    }

    public Apple(String IMEI) {
        super(IMEI);
        this.batteryLife = 48;
        this.color = "White";
        this.material = "Plastic";
    }
}