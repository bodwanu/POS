package main.se.kth.iv1350.pos.startup;

import main.se.kth.iv1350.pos.controller.Controller;
import main.se.kth.iv1350.pos.integration.*;
import main.se.kth.iv1350.pos.view.View;

/**
 * The Main class initializes and executes a sample sale using various objects such as
 * ExternalSystemHandler, ExternalInventorySystem, Printer, Register, Controller, and View.
 */
public class Main {
    public static void main(String[] args) {
        ExternalSystemHandler systemHandler = new ExternalSystemHandler();
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        Printer printer = new Printer();
        Register register = new Register(1000);
        Controller controller = new Controller(inventorySystem, systemHandler, printer, register);
        View view = new View(controller);

        view.executeSampleSale();
    }
}
