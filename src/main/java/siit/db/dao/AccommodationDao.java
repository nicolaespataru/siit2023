package siit.db.dao;
import siit.db.model.AccommodationModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AccommodationDao {

    private static final String INSERT_ACCOMMODATION_QUERY = "INSERT INTO accommodation (id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_ACCOMMODATIONS_QUERY = "SELECT * FROM accommodation";

    public void insertAccommodation(AccommodationModel accommodation) {
        try (Connection connection = getDBConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOMMODATION_QUERY)) {

            preparedStatement.setInt(1, accommodation.getId());
            preparedStatement.setString(2, accommodation.getType());
            preparedStatement.setString(3, accommodation.getBedType());
            preparedStatement.setInt(4, accommodation.getMaxGuests());
            preparedStatement.setString(5, accommodation.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<AccommodationModel> getAllAccommodations() {
        List<AccommodationModel> accommodations = new ArrayList<>();

        try (Connection connection = getDBConnection();
             Statement stmt = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOMMODATIONS_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                AccommodationModel accommodation = new AccommodationModel();
                accommodation.setId(resultSet.getInt("id"));
                accommodation.setType(resultSet.getString("type"));
                accommodation.setBedType(resultSet.getString("bed_type"));
                accommodation.setMaxGuests(resultSet.getInt("max_guests"));
                accommodation.setDescription(resultSet.getString("description"));

                accommodations.add(accommodation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accommodations;
    }

    private Connection getDBConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "12345678");
        return DriverManager.getConnection(url, props);
    }
}
