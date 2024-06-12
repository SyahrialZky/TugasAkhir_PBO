package com.tugasakhir_pbo.model;

import com.tugasakhir_pbo.db.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private int id;
    private String name;
    private int stock;
    private int price;

    public Item(int id, String name, int stock, int price) {
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
    public static List<Item> getAllItems() {
        List<Item> itemsList = new ArrayList<>();
        String query = "SELECT * FROM items";

        try (Connection conn = connection.getConnection(); // Adjusted to match your package
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int stock = rs.getInt("stock");
                int price = rs.getInt("price");

                Item item = new Item(id, name, stock, price);
                itemsList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemsList;
    }

    // Overridable method
    public String getItemDetails() {
        return "Item: " + name + ", Stock: " + stock + ", Price: " + price;
    }

//    public static void main(String[] args) {
//        List<Items> items = getAllItems();
//        for (Items item : items) {
//            System.out.println(item.getItemDetails());
//        }
//    }
}
