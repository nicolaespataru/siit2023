package org.example;

class SamsungGalaxy6 extends Samsung {
    public SamsungGalaxy6() {
        super();
    }
    public SamsungGalaxy6(String IMEI) {
        super(IMEI);
        this.color = "Blue";
        this.material = "Metal";
        this.batteryLife = 48;
    }
}
