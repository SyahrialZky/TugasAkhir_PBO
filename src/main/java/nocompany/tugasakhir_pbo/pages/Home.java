package nocompany.tugasakhir_pbo.pages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Home extends javax.swing.JFrame {

    private JPanel cards;
    private CardLayout cardLayout;

    public Home() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home Kasir");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem newSale = new JMenuItem("New Sale");
        JMenuItem viewSales = new JMenuItem("View Sales");
        JMenuItem manageInventory = new JMenuItem("Manage Inventory");

        menu.add(newSale);
        menu.add(viewSales);
        menu.add(manageInventory);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        JPanel newSalePanel = createNewSalePanel();
        JPanel viewSalesPanel = new JPanel();
        JPanel manageInventoryPanel = new JPanel();

        cards.add(newSalePanel, "New Sale");
        cards.add(viewSalesPanel, "View Sales");
        cards.add(manageInventoryPanel, "Manage Inventory");

        newSale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "New Sale");
            }
        });

        viewSales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "View Sales");
            }
        });

        manageInventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "Manage Inventory");
            }
        });

        getContentPane().add(cards);
        pack();
        setLocationRelativeTo(null);
    }

    private JPanel createNewSalePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columnNames = {"Item", "Quantity", "Price", "Total"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        JPanel availableItemsPanel = new JPanel(new GridLayout(0, 1));
        availableItemsPanel.setBorder(BorderFactory.createTitledBorder("Available Items"));

        try {
            Connection connection = nocompany.tugasakhir_pbo.db.connection.getConnection();
            String query = "SELECT name, price FROM item";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String itemName = resultSet.getString("name");
                double itemPrice = resultSet.getDouble("price");
                availableItemsPanel.add(new JLabel(itemName + " - Rp" + String.format("%,.2f", itemPrice)));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to fetch items from database.");
        }

        JPanel transactionPanel = new JPanel(new GridLayout(0, 2));
        transactionPanel.setBorder(BorderFactory.createTitledBorder("Transaction"));

        JLabel lblTotal = new JLabel("Total: ");
        JTextField txtTotal = new JTextField();
        txtTotal.setEditable(false);

        JLabel lblPayment = new JLabel("Payment: ");
        JTextField txtPayment = new JTextField();

        JLabel lblChange = new JLabel("Change: ");
        JTextField txtChange = new JTextField();
        txtChange.setEditable(false);

        JButton btnCalculate = new JButton("Calculate Change");

        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double total = Double.parseDouble(txtTotal.getText());
                    double payment = Double.parseDouble(txtPayment.getText());
                    double change = payment - total;
                    txtChange.setText(String.valueOf(change));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Home.this, "Invalid payment amount.");
                }
            }
        });

        transactionPanel.add(lblTotal);
        transactionPanel.add(txtTotal);
        transactionPanel.add(lblPayment);
        transactionPanel.add(txtPayment);
        transactionPanel.add(lblChange);
        transactionPanel.add(txtChange);
        transactionPanel.add(new JLabel());
        transactionPanel.add(btnCalculate);

        panel.add(availableItemsPanel, BorderLayout.WEST);
        panel.add(tableScrollPane, BorderLayout.CENTER);
        panel.add(transactionPanel, BorderLayout.SOUTH);

        JButton btnAddItem = new JButton("Add Item");
        btnAddItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = JOptionPane.showInputDialog("Enter item (format: name-price): ");
                String quantityStr = JOptionPane.showInputDialog("Enter quantity: ");
                try {
                    String[] itemParts = item.split("-");
                    String itemName = itemParts[0];
                    double itemPrice = Double.parseDouble(itemParts[1]);
                    int quantity = Integer.parseInt(quantityStr);
                    double total = itemPrice * quantity;
                    tableModel.addRow(new Object[]{itemName, quantity, itemPrice, total});

                    double currentTotal = 0;
                    for (int i = 0; i < tableModel.getRowCount(); i++) {
                        currentTotal += (double) tableModel.getValueAt(i, 3);
                    }
                    txtTotal.setText(String.valueOf(currentTotal));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Home.this, "Invalid input format.");
                }
            }
        });

        panel.add(btnAddItem, BorderLayout.NORTH);

        return panel;
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
}
