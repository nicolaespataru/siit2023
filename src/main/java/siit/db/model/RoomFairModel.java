package siit.db.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class RoomFairModel {
    private int id;
    private double value;
    private String season;

    // Constructors, getters, and setters

    public RoomFairModel() {
    }

    public RoomFairModel(int id, double value, String season) {
        this.id = id;
        this.value = value;
        this.season = season;
    }

    // Getters and setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

}
