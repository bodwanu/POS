package main.se.kth.iv1350.pos.model;

import main.se.kth.iv1350.pos.dto.ItemDTO;
import main.se.kth.iv1350.pos.dto.SaleDTO;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * The Sale class represents a sale transaction with a shopping cart, discount, and methods to
 * calculate the total price and VAT.
 */
public class Sale {

    private final ShoppingCart shoppingCart;
    private final LocalDateTime saleTime;
    private double discount;

    private double paidAmount;
    private double change;

    public Sale() {
        this.shoppingCart = new ShoppingCart();
        this.saleTime = LocalDateTime.now();
        this.discount = 0;
    }

    /**
     * The function adds an item with a specified quantity to a shopping cart.
     * 
     * @param item The item parameter is an object of type ItemDTO, which represents a product or item
     * that can be added to a shopping cart. It likely contains information such as the item's name,
     * price, description, and possibly a unique identifier.
     * @param quantity The quantity parameter represents the number of items of the given itemDTO that
     * the user wants to add to their shopping cart.
     */
    public void addItem(ItemDTO item, int quantity) {
        shoppingCart.addItem(item, quantity);
    }

  
    /**
     * The function applies a discount to a given value.
     * 
     * @param discount The "discount" parameter is a double type variable that represents the amount of
     * discount to be applied to a product or service. It is a percentage value that can range from 0
     * to 100. For example, if the discount is 20, it means that the product or service will be sold
     */
    public void applyDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * This Java function generates a SaleDTO object with calculated total price, total VAT, discounted
     * total price, and sale time and items from a shopping cart.
     * 
     * @return A SaleDTO object is being returned.
     */

    public SaleDTO generateSaleDTO() {
        double totalPrice = calculateTotalPrice();
        double totalVAT = calculateTotalVAT();
        double totalPriceWithDiscount = getTotalPriceInclDiscount();
        return new SaleDTO(saleTime, shoppingCart.getItems(), totalPriceWithDiscount, totalVAT, discount, paidAmount, change);
    }

    private double calculateTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<ItemDTO, Integer> entry : shoppingCart.getItems().entrySet()) {
            totalPrice += entry.getKey().getItemPrice() * entry.getValue();
        }
        return totalPrice;
    }

    private double calculateTotalVAT() {
        double totalVAT = 0;
        for (Map.Entry<ItemDTO, Integer> entry : shoppingCart.getItems().entrySet()) {
            double itemVAT = entry.getKey().getItemVAT() * entry.getKey().getItemPrice() * entry.getValue();
            totalVAT += itemVAT;
        }
        return totalVAT;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getChange() {
        return change;
    }

    public double getTotalPriceInclDiscount() {
        double totalPriceInclVAT = calculateTotalPrice() + calculateTotalVAT();
        return Math.round(totalPriceInclVAT * (1 - discount));


    }

}

