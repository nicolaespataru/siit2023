package org.example;

public class SamsungGalaxyS23 extends Samsung {
    public SamsungGalaxyS23() {
        super();
    }
    public SamsungGalaxyS23(String IMEI) {
        super(IMEI);
        this.color = "Black";
        this.material = "Metal";
        this.batteryLife = 56;
    }
}
