package main.se.kth.iv1350.pos.integration;

import main.se.kth.iv1350.pos.dto.SaleDTO;

/**
 * The ExternalSystemHandler class handles external accounting and discount systems for a sale.
 */
public class ExternalSystemHandler {
    private ExternalAccountingSystem externalAccountingSystem;
    private DiscountHandler discountHandler;

    public ExternalSystemHandler() {
        this.externalAccountingSystem = new ExternalAccountingSystem();
        this.discountHandler = new DiscountHandler();
    }

   /**
    * The function records a sale in an external accounting system using a SaleDTO object.
    * 
    * @param sale SaleDTO object which contains information about a sale, such as the date, time,
    * customer information, and items purchased.
    */
    public void recordSaleInAccountingSystem(SaleDTO sale) {
        externalAccountingSystem.registerSale(sale);
    }

   /**
    * This function returns the discount for a given customer ID using a discount handler.
    * 
    * @param customerID The customerID is a unique identifier for a specific customer in the system. 
    * @return A double value representing the discount for a customer with the given customerID.
    */
    public double getDiscountByCustomerID(String customerID) {
        return discountHandler.getDiscountByCustomerID(customerID);
    }
}
