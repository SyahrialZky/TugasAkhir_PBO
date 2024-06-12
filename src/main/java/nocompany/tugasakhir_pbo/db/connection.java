package nocompany.tugasakhir_pbo.db;
import java.sql.*;

public class connection {
    private static final String URL = "jdbc:mysql://localhost:3306/pbo";
    private static final String USERNAME = "bilal";
    private static final String PASSWORD = "bilal123";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }


    //test connection
//    public static void main(String[] args) {
//        try {
//            Connection connection = getConnection();
//            System.out.println("Connection successful");
//            closeConnection(connection);
//        } catch (SQLException e) {
//            System.out.println("Connection failed");
//            e.printStackTrace();
//        }
//    }
}
