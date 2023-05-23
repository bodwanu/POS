package test.se.kth.iv1350.pos.controller;

import main.se.kth.iv1350.pos.controller.Controller;
import main.se.kth.iv1350.pos.integration.*;
import main.se.kth.iv1350.pos.model.Sale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller controller;

    @BeforeEach
    void setUp() {
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        ExternalSystemHandler externalSystem = new ExternalSystemHandler();
        Printer printer = new Printer();
        Register register = new Register(1000);
        controller = new Controller(inventorySystem, externalSystem, printer, register);
    }

    @Test
    void testStartNewSale() {
        controller.startNewSale();
        Sale sale = controller.getSale();
        assertNotNull(sale, "Sale object not initialized properly.");
    }

    @Test
    void testRegisterItem() {
        controller.startNewSale();
        String itemID = "1";
        int quantity = 3;
        assertDoesNotThrow(() -> controller.registerItem(itemID, quantity), "Exception thrown while registering item.");
    }
}
