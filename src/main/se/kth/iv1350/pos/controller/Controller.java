package main.se.kth.iv1350.pos.controller;

import main.se.kth.iv1350.pos.dto.ItemDTO;
import main.se.kth.iv1350.pos.dto.SaleDTO;
import main.se.kth.iv1350.pos.exception.DatabaseConnectionException;
import main.se.kth.iv1350.pos.exception.ItemNotFoundException;
import main.se.kth.iv1350.pos.integration.*;
import main.se.kth.iv1350.pos.model.*;
import main.se.kth.iv1350.pos.utils.RevenueObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * The Controller class manages the sale process by interacting with external systems and updating the
 * sale log.
 */
public class Controller {
    private ExternalInventorySystem inventorySystem;
    private ExternalSystemHandler systemHandler;
    private Printer printer;
    private Sale sale;
    private Register register;

    private SaleLog saleLog;

    private List<RevenueObserver> revenueObservers = new ArrayList<>();


    public Controller(ExternalInventorySystem inventorySystem, ExternalSystemHandler systemHandler, Printer printer, Register register) {
        this.inventorySystem = inventorySystem;
        this.systemHandler = systemHandler;
        this.printer = printer;
        this.register = register;
        this.saleLog = new SaleLog();
    }

    public void addRevenueObserver(RevenueObserver observer) {
        revenueObservers.add(observer);
    }

    public void startNewSale() {
        sale = new Sale();
    }

    /**
     * The function returns information about an item based on its ID from an inventory system.
     * 
     * @param itemID The parameter "itemID" is a string variable that represents the unique identifier
     * of an item in the inventory system. 
     * @return The method `getItemInfo` is returning an `ItemDTO` object which contains information
     * about the item with the specified `itemID`. 
     */
    public ItemDTO getItemInfo(String itemID) throws ItemNotFoundException, DatabaseConnectionException {
        return inventorySystem.getItem(itemID);
    }

    /**
     * The function registers an item with a given item ID and quantity to a sale.
     * 
     * @param itemID A string representing the unique identifier of an item.
     * @param quantity The quantity parameter represents the number of items being registered for sale.
     */
    public void registerItem(String itemID, int quantity) throws ItemNotFoundException, DatabaseConnectionException{
        ItemDTO item = getItemInfo(itemID);
        sale.addItem(item, quantity);
    }

    /**
     * This function applies a discount to a sale based on the customer ID.
     * 
     * @param customerID The customerID is a unique identifier for a specific customer in the system.
     * It is used to retrieve the discount percentage that is associated with that customer's account.
     */
    public void applyDiscount(String customerID) {
        double discount = systemHandler.getDiscountByCustomerID(customerID);
        sale.applyDiscount(discount);
    }

    /**
     * The function completes a sale by processing a payment and ending the sale.
     * 
     * @param paidAmount The amount of money paid by the customer to complete the sale.
     */
    public void completeSale(double paidAmount) {
        pay(paidAmount);
        endSale();
        notifyObservers();
    }

    /**
    * The function notifies revenue observers of a new sale with the total cost.
    */
    private void notifyObservers() {
        double totalCost = sale.getTotalPriceInclDiscount();
        for (RevenueObserver observer : revenueObservers) {
            observer.newSale(totalCost);
        }
    }

    /**
     * The "pay" function calculates the change and sets the paid amount and change in a sale object.
     * 
     * @param paidAmount The amount of money paid by the customer for the sale.
     */
    public void pay(double paidAmount) {
        double change = paidAmount - sale.getTotalPriceInclDiscount();
        sale.setPaidAmount(paidAmount);
        sale.setChange(change);
    }

    public Sale getSale() {
        return sale;
    }

    /**
     * The function ends a sale by generating a sale DTO, recording the sale in the accounting system,
     * updating the inventory, updating the register balance, printing a receipt, logging the sale, and
     * displaying the amount paid by the customer and the change given back.
     */
    public void endSale() {
        SaleDTO saleDTO = sale.generateSaleDTO();
        systemHandler.recordSaleInAccountingSystem(saleDTO);
        inventorySystem.updateInventory(saleDTO);
        Receipt receipt = new Receipt(saleDTO);
        printer.printReceipt(receipt);
        register.updateBalance(saleDTO.getTotalPriceInclDiscount());
        System.out.println("Amount paid by the customer: " + sale.getPaidAmount());
        System.out.println("Change given back: " + sale.getChange());
        System.out.println("Current register balance: " + register.getBalance());
        System.out.println("");
        saleLog.logSale(saleDTO);
    }
}
