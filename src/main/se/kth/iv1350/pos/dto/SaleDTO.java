package main.se.kth.iv1350.pos.dto;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * The `SaleDTO` class represents a data transfer object for a sale, containing
 * information such as the time of sale, items and their quantities, total price, and total VAT.
 */
public class SaleDTO {

    private final LocalDateTime timeOfSale;
    private final Map<ItemDTO, Integer> itemsInCurrentSale;
    private final double totalPrice;
    private final double totalVAT;
    private final double discount;

    /*
    private double paidAmount;
    private double change;
     */

    public SaleDTO(LocalDateTime timeOfSale, Map<ItemDTO, Integer> itemsInCurrentSale, double totalPrice, double totalVAT, double discount, double paidAmount, double change) {
        this.timeOfSale = timeOfSale;
        this.itemsInCurrentSale = itemsInCurrentSale;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
        this.discount = discount;
        //this.paidAmount = paidAmount;
        //this.change = change;
    }

    /**
     * The function returns the time of sale as a LocalTime object.
     * 
     * @return The method `getTimeOfSale()` is returning a `LocalTime` object.
     */
    public LocalDateTime getTimeOfSale() {
        return timeOfSale;
    }

    /**
     * The function returns the total price as a float value.
     * 
     * @return The method `getTotalPrice()` is returning a `float` value which
     *         represents the total
     *         price.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * The function returns the total VAT value as a float.
     * 
     * @return The method `getTotalVAT()` is returning the value of the variable
     *         `totalVAT`, which is
     *         likely a float representing the total value-added tax.
     */
    public double getTotalVAT() {
        return totalVAT;
    }

    /**
     * The function returns a HashMap containing the items and their corresponding
     * quantities in the current sale.
     * 
     * @return A HashMap containing ItemDTO objects as keys and Integer values
     *         representing the
     *         quantity of each item in the current sale.
     */
    public Map<ItemDTO, Integer> getItemsInCurrentSale() {
        return itemsInCurrentSale;
    }



    public double getDiscount() {
        return discount;
    }

    public double getTotalPriceInclVAT() {
        return totalPrice + totalVAT;
    }

    public double getTotalPriceInclDiscount() {
        return (totalPrice + totalVAT) - ((totalPrice + totalVAT) * discount);
    }

    /*
    public double getPaidAmount() {
        return paidAmount;
    }

    public double getChange() {
        return change;
    }
     */
}
