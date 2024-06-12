package nocompany.tugasakhir_pbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/kasir-java";
    private static final String USERNAME = "bilal";
    private static final String PASSWORD = "bilal123";

    private static Connection connection;

    // Static block for initializing the connection
    static {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Koneksi berhasil cuy");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error nyambungin ke database", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
