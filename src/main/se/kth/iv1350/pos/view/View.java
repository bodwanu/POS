package main.se.kth.iv1350.pos.view;

import main.se.kth.iv1350.pos.controller.Controller;
import main.se.kth.iv1350.pos.dto.ItemDTO;
import main.se.kth.iv1350.pos.exception.ItemNotFoundException;
import main.se.kth.iv1350.pos.exception.DatabaseConnectionException;
import main.se.kth.iv1350.pos.utils.FileLogger;
import main.se.kth.iv1350.pos.utils.TotalRevenueFileOutput;

/**
 * The View class contains a method that executes a sample sale by interacting with the Controller
 * class.
 */
public class View {
    private Controller controller;
    private FileLogger fileLogger;

    public View(Controller controller) {
        this.controller = controller;
        this.fileLogger = new FileLogger();
        this.controller.addRevenueObserver(new TotalRevenueView());
        this.controller.addRevenueObserver(new TotalRevenueFileOutput());
    }


    /**
     * The function executes a sample sale by registering items, applying a discount, completing the
     * sale, and ending the sale.
     */
    public void executeSampleSale() {
        controller.startNewSale();

        String[] itemIDs = {"1", "2", "3", "444"};  // Adding "444" to simulate database failure
        int[] quantities = {3, 6, 1, 2};

        System.out.println("---- START SALE -----");
        for (int i = 0; i < itemIDs.length; i++) {
            try {
                controller.registerItem(itemIDs[i], quantities[i]);
                ItemDTO item = controller.getItemInfo(itemIDs[i]);
                System.out.println("Registered item: " + item.getItemDescription() + ", Quantity: " + quantities[i]);
            } catch (ItemNotFoundException | DatabaseConnectionException e) {
                System.out.println(e.getMessage());
                fileLogger.log(e.getMessage());
            }
        }

        controller.applyDiscount("1337");
        controller.completeSale(200);
        controller.endSale();
        System.out.println("\n-----SALE COMPLETED-----");
    }
}
