package nocompany.tugasakhir_pbo.model;

import nocompany.tugasakhir_pbo.db.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import nocompany.tugasakhir_pbo.model.DetailTransaction;

public class Transaction extends Object {
    private int id;
    private Date date;
    private int totalAmount;

    // Constructor
   public Transaction( int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public static boolean createTransaction(List<DetailTransaction> details, int payment) {
        String insertTransactionQuery = "INSERT INTO transactions (date, total_amount, payment, change_amount) VALUES (?, ?, ?, ?)";
        String insertDetailQuery = "INSERT INTO detail_transactions (name, price, qty, transaction_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = connection.getConnection();
             PreparedStatement transactionStmt = conn.prepareStatement(insertTransactionQuery, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement detailStmt = conn.prepareStatement(insertDetailQuery)) {

            conn.setAutoCommit(false);

            // Calculate total amount
            int totalAmount = details.stream().mapToInt(detail -> detail.getPrice() * detail.getQty()).sum();
            Date date = new Date();
            int changeAmount = payment - totalAmount;

            // Insert transaction
            transactionStmt.setDate(1, new java.sql.Date(date.getTime()));
            transactionStmt.setInt(2, totalAmount);
            transactionStmt.setInt(3, payment);
            transactionStmt.setInt(4, changeAmount);
            transactionStmt.executeUpdate();

            // Retrieve generated transaction ID
            try (ResultSet generatedKeys = transactionStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int transactionId = generatedKeys.getInt(1);

                    // Insert details
                    for (DetailTransaction detail : details) {
                        detailStmt.setString(1, detail.getName());
                        detailStmt.setInt(2, detail.getPrice());
                        detailStmt.setInt(3, detail.getQty());
                        detailStmt.setInt(4, transactionId);
                        detailStmt.addBatch();

                        // Update item stock
                        updateItemStock(detail.getItemId(), detail.getQty());
                    }
                    detailStmt.executeBatch();
                } else {
                    conn.rollback();
                    return false;
                }
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void updateItemStock(int itemId, int qty) throws SQLException {
        String query = "UPDATE items SET stock = stock - ? WHERE id = ?";
        try (Connection conn = connection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, qty);
            stmt.setInt(2, itemId);
            stmt.executeUpdate();
        }
    }

    private static int getTotalAmount(List<DetailTransaction> details) {
        return details.stream().mapToInt(detail -> detail.getPrice() * detail.getQty()).sum();
    }

    // Override toString method
    @Override
    public String toString() {
        return "Transaction sebesar : " +
                 + totalAmount + " Berhasil " +
                '}';
    }
}
