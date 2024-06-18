package nocompany.tugasakhir_pbo.model;

import nocompany.tugasakhir_pbo.db.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Items {

    private int id;
    private String name;
    private int stock;
    private int price;

    public Items(int id, String name, int stock, int price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    // get items from database
    public static List<Items> getAllItems() {
        List<Items> itemsList = new ArrayList<>();
        String query = "SELECT * FROM items";

        try (Connection conn = connection.getConnection(); // Adjusted to match your package
                 PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int stock = rs.getInt("stock");
                int price = rs.getInt("price");

                Items item = new Items(id, name, stock, price);
                itemsList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemsList;
    }

    public static void updateStock(String itemName, int additionalStock) throws SQLException {
        String sqlUpdateStock = "UPDATE items SET stock = stock + ? WHERE name = ?";
        try (Connection conn = connection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sqlUpdateStock)) {
            stmt.setInt(1, additionalStock);
            stmt.setString(2, itemName);
            stmt.executeUpdate();
        }
    }

    public static void deleteItem(String itemName) throws SQLException {
        String sqlDelete = "DELETE FROM items WHERE name = ?";
        try (Connection connection = nocompany.tugasakhir_pbo.db.connection.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlDelete)) {
            statement.setString(1, itemName);
            statement.executeUpdate();
        }
    }

    // Overridable method
    public String getItemDetails() {
        return "Item: " + name + ", Stock: " + stock + ", Price: " + price;
    }

    // Test get items with main method
    // public static void main(String[] args) {
    // List<Items> items = getAllItems();
    // for (Items item : items) {
    // System.out.println(item.getItemDetails());
    // }
    // }
}
