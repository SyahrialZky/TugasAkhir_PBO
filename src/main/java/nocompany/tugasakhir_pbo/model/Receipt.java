package nocompany.tugasakhir_pbo.model;

import java.util.List;

public class Receipt {
    private List<DetailTransaction> detailTransactions;
    private int totalAmount;
    private int payment;
    private int changePayment;

    public Receipt(List<DetailTransaction> detailTransactions, int totalAmount, int payment) {
        this.detailTransactions = detailTransactions;
        this.totalAmount = totalAmount;
        this.payment = payment;
        this.changePayment = payment - totalAmount;
    }

    public List<DetailTransaction> getDetailTransactions() {
        return detailTransactions;
    }

    public void setDetailTransactions(List<DetailTransaction> detailTransactions) {
        this.detailTransactions = detailTransactions;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
        this.changePayment = payment - totalAmount;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
        this.changePayment = payment - totalAmount;
    }

    public int getChangePayment() {
        return changePayment;
    }

    @Override
    public String toString() {
        StringBuilder receiptStr = new StringBuilder("Receipt:\n");
        for (DetailTransaction dt : detailTransactions) {
            receiptStr.append("Item: ").append(dt.getName())
                       .append(", Price: ").append(dt.getPrice())
                       .append(", Quantity: ").append(dt.getQty())
                       .append("\n");
        }
        receiptStr.append("Total Amount: ").append(totalAmount).append("\n")
                  .append("Payment: ").append(payment).append("\n")
                  .append("Change: ").append(changePayment).append("\n");
        return receiptStr.toString();
    }
}
