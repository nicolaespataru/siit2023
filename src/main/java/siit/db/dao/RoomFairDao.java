package siit.db.dao;
import siit.db.model.RoomFairModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RoomFairDao {

    private static final String INSERT_ROOM_FAIR_QUERY = "INSERT INTO room_fair (id, value, season) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_ROOM_FAIRS_QUERY = "SELECT * FROM room_fair";

    public void insertRoomFair(RoomFairModel roomFair) {
        try (Connection connection = getDBConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_FAIR_QUERY)) {

            preparedStatement.setInt(1, roomFair.getId());
            preparedStatement.setDouble(2, roomFair.getValue());
            preparedStatement.setString(3, roomFair.getSeason());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RoomFairModel> getAllRoomFairs() {
        List<RoomFairModel> roomFairs = new ArrayList<>();

        try (Connection connection = getDBConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOM_FAIRS_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                RoomFairModel roomFair = new RoomFairModel();
                roomFair.setId(resultSet.getInt("id"));
                roomFair.setValue(resultSet.getDouble("value"));
                roomFair.setSeason(resultSet.getString("season"));

                roomFairs.add(roomFair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomFairs;
    }

    private Connection getDBConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "12345678");
        return DriverManager.getConnection(url, props);
    }
}
