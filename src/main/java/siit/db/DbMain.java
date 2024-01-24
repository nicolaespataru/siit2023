package siit.db;


import java.sql.*;
import java.util.Properties;

public class DbMain {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "cacat1");

        try (Connection connection = DriverManager.getConnection(url, props);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select * from customers");
        ) {

//            stmt.executeQuery("INSERT INTO ORDERS (NUMBER, PLACED, CUSTOMER_ID) " +
//                    " VALUES ('From Java Code 10', '1999-7-10 10:20:30', 1)");
            System.out.println("DB connection has been reached");
            while (rs.next()) {
//                System.out.println( rs.getString(1));
                System.out.println( rs.getString("email"));
            }
            //TODO interact with DB
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
