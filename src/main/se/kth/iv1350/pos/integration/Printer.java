package main.se.kth.iv1350.pos.integration;
import main.se.kth.iv1350.pos.model.Receipt;


public class Printer {

    public void printReceipt(Receipt receipt) {
        System.out.println(receipt.generateReceipt());
    }
}
