package nocompany.tugasakhir_pbo.model;

public class DetailTransaction {
    private int id;
    private String name;
    private int price;
    private int qty;
    private int transactionId;
    private int itemId;

    public DetailTransaction(String name, int price, int qty, int itemId) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.itemId = itemId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getItemId() {
        return itemId;
    }
}
