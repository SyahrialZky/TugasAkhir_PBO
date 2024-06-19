/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nocompany.tugasakhir_pbo.pages;

import java.util.List;
import nocompany.tugasakhir_pbo.model.DetailTransaction;


/**
 *
 * @author Lenovo
 */
public class Struk {
    private List<DetailTransaction> details;
    private int totalAmount;
    private int payment;
    private int changeAmount;
    
     public Struk(List<DetailTransaction> details, int totalAmount, int payment, int changeAmount) {
        this.details = details;
        this.totalAmount = totalAmount;
        this.payment = payment;
        this.changeAmount = changeAmount;
     }
     
     public String generateStrukText() {
        StringBuilder strukText = new StringBuilder();
        strukText.append("========== STRUK BELANJA ==========\n");
        strukText.append(String.format("%-20s %-10s %-10s\n", "Nama Barang", "Harga", "Jumlah"));
        strukText.append("------------------------------------\n");

        for (DetailTransaction detail : details) {
            strukText.append(String.format("%-20s %-10d %-10d\n", detail.getName(), detail.getPrice(), detail.getQty()));
        }

        strukText.append("------------------------------------\n");
        strukText.append(String.format("Total Belanja : %d\n", totalAmount));
        strukText.append(String.format("Tunai : %d\n", payment));
        strukText.append(String.format("Kembalian : %d\n", changeAmount));
        strukText.append("====================================\n");

        return strukText.toString();
    }
     
}
