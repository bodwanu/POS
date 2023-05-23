package main.se.kth.iv1350.pos.model;

import main.se.kth.iv1350.pos.dto.SaleDTO;

import java.time.format.DateTimeFormatter;

public class Receipt {
    private final SaleDTO sale;

    public Receipt(SaleDTO sale) {
        this.sale = sale;
    }

   /**
    * The function generates a receipt for a sale with details such as time of sale, items purchased,
    * total price, total VAT, and discount.
    * 
    * @return The method `generateReceipt()` returns a string that represents a receipt for a sale,
    * including the time of sale, the items purchased, the total price, total VAT, and any discounts
    * applied.
    */
   public String generateReceipt() {
       StringBuilder receiptBuilder = new StringBuilder();

       receiptBuilder.append("\n----- RECEIPT -----\n");
       receiptBuilder.append("Time of Sale: ");
       receiptBuilder.append(sale.getTimeOfSale().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
       receiptBuilder.append("\n\nItems:\n");

       sale.getItemsInCurrentSale().forEach((item, quantity) -> {
           receiptBuilder.append(item.getItemDescription());
           receiptBuilder.append(" x ");
           receiptBuilder.append(quantity);
           receiptBuilder.append(" @ ");
           receiptBuilder.append(item.getItemPrice());
           receiptBuilder.append(" kr ");
           receiptBuilder.append("\n");
       });

       receiptBuilder.append("\nTotal Price: ");
       receiptBuilder.append(sale.getTotalPrice());
       receiptBuilder.append(" kr ");
       receiptBuilder.append("\nTotal VAT: ");
       receiptBuilder.append(sale.getTotalVAT());
       receiptBuilder.append(" kr ");
       receiptBuilder.append("\nTotal Price incl. VAT: ");
       receiptBuilder.append(sale.getTotalPriceInclVAT());
       receiptBuilder.append(" kr ");
       receiptBuilder.append("\n");
       receiptBuilder.append("\nDiscount: ");
       receiptBuilder.append(sale.getDiscount());
       receiptBuilder.append("\nTotal Price incl. Discount: ");
       receiptBuilder.append(sale.getTotalPriceInclDiscount());
       receiptBuilder.append(" kr ");
       receiptBuilder.append("\n\n----- END RECEIPT -----\n");

       return receiptBuilder.toString();
   }
}
