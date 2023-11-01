package org.example;

import java.util.List;

abstract class Samsung extends Phone {
    public Samsung() {
        this.IMEI = "Default";
        this.batteryLife = 48;
        this.color = "White";
        this.material = "Plastic";
    }

    public Samsung(String IMEI) {
        super(IMEI);
        this.batteryLife = 48;
        this.color = "White";
        this.material = "Plastic";
    }
}