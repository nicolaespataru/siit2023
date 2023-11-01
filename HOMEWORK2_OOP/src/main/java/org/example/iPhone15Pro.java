package org.example;

public class iPhone15Pro extends Apple {
    public iPhone15Pro() {
        super();
    }
    public iPhone15Pro(String IMEI) {
        super(IMEI);
        this.color = "Black";
        this.material = "Metal";
        this.batteryLife = 56;
    }

}