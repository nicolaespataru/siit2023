package siit.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import siit.db.model.AccommodationRoomFairRelation;

public class AccommodationRoomFairRelationDao {

    private static final String INSERT_RELATION_QUERY = "INSERT INTO accommodation_room_fair_relation (id, accommodation_id, room_fair_id) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_RELATIONS_QUERY = "SELECT * FROM accommodation_room_fair_relation";

    public void insertAccommodationRoomFairRelation(int accommodationId, int roomFairId) {
        try (Connection connection = getDBConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RELATION_QUERY)) {

            // Assuming the id column is auto-incremented and doesn't need to be provided
            // If id is not auto-incremented, you may need to adjust the logic accordingly

            preparedStatement.setInt(2, accommodationId);
            preparedStatement.setInt(3, roomFairId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AccommodationRoomFairRelation> getAllRelations() {
        List<AccommodationRoomFairRelation> relations = new ArrayList<>();

        try (Connection connection = getDBConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RELATIONS_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                AccommodationRoomFairRelation relation = new AccommodationRoomFairRelation();
                relation.setId(resultSet.getInt("id"));
                relation.setAccommodationId(resultSet.getInt("accommodation_id"));
                relation.setRoomFairId(resultSet.getInt("room_fair_id"));

                relations.add(relation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return relations;
    }

    private Connection getDBConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123456789");
        return DriverManager.getConnection(url, props);
    }
}
