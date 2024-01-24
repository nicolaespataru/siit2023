package siit.db.model;

import java.sql.*;
import java.util.Properties;

public class AccommodationRoomFairRelation {

    private int id;
    private int accommodationId;
    private int roomFairId;

    // Constructors, getters, and setters

    public AccommodationRoomFairRelation() {
    }

    public AccommodationRoomFairRelation(int id, int accommodationId, int roomFairId) {
        this.id = id;
        this.accommodationId = accommodationId;
        this.roomFairId = roomFairId;
    }

    // Getters and setters...

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(int accommodationId) {
        this.accommodationId = accommodationId;
    }

    public int getRoomFairId() {
        return roomFairId;
    }

    public void setRoomFairId(int roomFairId) {
        this.roomFairId = roomFairId;
    }

    public double getRoomPrice() {
        double roomPrice = 0.0;

        try (Connection connection = getDBConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT rf.value FROM room_fair rf " +
                             "JOIN accommodation_room_fair_relation arfr " +
                             "ON rf.id = arfr.room_fair_id " +
                             "WHERE arfr.accommodation_id = ?")) {

            preparedStatement.setInt(1, this.accommodationId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    roomPrice = resultSet.getDouble("value");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomPrice;
    }

    private Connection getDBConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "12345678");
        return DriverManager.getConnection(url, props);
    }
}
