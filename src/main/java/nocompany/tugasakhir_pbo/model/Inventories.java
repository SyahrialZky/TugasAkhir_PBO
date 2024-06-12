/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nocompany.tugasakhir_pbo.model;

import nocompany.tugasakhir_pbo.db.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Inventories {

    private int history_id;
    private int item_id;
    private int quantity;
    private Date added_date = new Date();

    public Inventories(int history_id, int item_id, int quantity, Date added_date) {
        this.history_id = history_id;
        this.item_id = item_id;
        this.quantity = quantity;
        this.added_date = added_date;
    }

    public int getHistoryId() {
        return history_id;
    }

    public int getItemId() {
        return item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getAddedDate() {
        return added_date;
    }
    // get items from database

    public static List<Inventories> getAllInventories() {
        List<Inventories> inventoryList = new ArrayList<>();
        String query = "SELECT * FROM inventories";

        try (Connection conn = connection.getConnection(); // Adjusted to match your package
                 PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int history_id = rs.getInt("history_id");
                int item_id = rs.getInt("item_id");
                int quantity = rs.getInt("quantity");
                Date added_date = rs.getDate("added_date");

                Inventories inventory = new Inventories(history_id, item_id, quantity, added_date);
                inventoryList.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inventoryList;
    }
    
     public static void addInventory(int itemId, int quantity, String status) throws SQLException {
        String sql = "INSERT INTO inventories (item_id, quantity, status, added_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = connection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, itemId);
            pstmt.setInt(2, quantity);
            pstmt.setString(3, status);
            pstmt.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis())); // Current timestamp
            pstmt.executeUpdate();
        }
    }
     
      public static String getItemNameById(int itemId) {
        String itemName = "";
        String query = "SELECT name FROM items WHERE id = ?";

        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, itemId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    itemName = rs.getString("name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemName;
    }
      

    // Overridable method
    public String getInventoryDetails() {
        return "Item_id: " + item_id + ", History_id: " + history_id + ", quantity: " + quantity;
    }

    // Testing get items with main method
    public static void main(String[] args) {
        System.out.println("test");
        List<Inventories> items = getAllInventories();
        for (Inventories item : items) {
            System.out.println(item.getInventoryDetails());
        }
    }

}
