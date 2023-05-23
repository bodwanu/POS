package main.se.kth.iv1350.pos.integration;

import main.se.kth.iv1350.pos.dto.SaleDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * The ExternalAccountingSystem class records sales in a list and prints a message indicating that the
 * sale is being recorded in an external accounting system.
 */
public class ExternalAccountingSystem {
    private List<SaleDTO> sales;

    public ExternalAccountingSystem() {
        sales = new ArrayList<>();
    }

    /**
     * The function adds a sale to a list and prints a message indicating that the sale is being
     * recorded in an external accounting system.
     * 
     * @param sale a data transfer object that contains information about a sale, such as the customer, items purchased, and total cost. 
     */
    public void registerSale(SaleDTO sale) {
        sales.add(sale);
        System.out.println("Recording sale in the external accounting system...");
    }
}
