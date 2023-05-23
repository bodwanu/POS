package main.se.kth.iv1350.pos.integration;

/**
 * The DiscountHandler class provides discounts based on customer ID.
 */
public class DiscountHandler {
   /**
    * The function returns a discount percentage based on the customer ID provided.
    * 
    * @param customerID The customer ID is a unique identifier assigned to each customer in a system.
    * It is used to differentiate between different customers and to retrieve their information and
    * preferences. 
    * @return The method returns a double value representing the discount percentage for a given
    * customer ID. 
    */
    public double getDiscountByCustomerID(String customerID) {
        if (customerID.equals("12345")) {
            return 0.10; // 10% discount for this customer
        }
        if (customerID.equals("1337")) {
            return 0.20; // 20% discount for this customer
        } else {
            return 0; // No discount for other customers
        }
    }
}
