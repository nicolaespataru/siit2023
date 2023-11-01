package org.example;

public class iPhone15S extends Apple {
    public iPhone15S() {
        super();
    }
    public iPhone15S(String IMEI) {
        super(IMEI);
        this.color = "Black";
        this.material = "Metal";
        this.batteryLife = 56;
    }
}