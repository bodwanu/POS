package test.se.kth.iv1350.pos.integration;

import main.se.kth.iv1350.pos.dto.ItemDTO;
import main.se.kth.iv1350.pos.dto.SaleDTO;
import main.se.kth.iv1350.pos.exception.DatabaseConnectionException;
import main.se.kth.iv1350.pos.exception.ItemNotFoundException;
import main.se.kth.iv1350.pos.integration.ExternalInventorySystem;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ExternalInventorySystemTest {

    @Test
    public void testGetItem() throws DatabaseConnectionException, ItemNotFoundException {
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        ItemDTO item = inventorySystem.getItem("1");
        assertEquals("Banana", item.getItemDescription());
    }

    @Test(expected = ItemNotFoundException.class)
    public void testGetItemNotFound() throws DatabaseConnectionException, ItemNotFoundException {
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        inventorySystem.getItem("4"); // Expecting ItemNotFoundException
    }

    @Test(expected = DatabaseConnectionException.class)
    public void testGetItemDatabaseException() throws DatabaseConnectionException, ItemNotFoundException {
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        inventorySystem.getItem("999"); // Expecting DatabaseConnectionException
    }

    @Test
    public void testUpdateInventory() {
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        HashMap<ItemDTO, Integer> itemsInSale = new HashMap<>();
        itemsInSale.put(new ItemDTO("2", "Mango", 20, 0.25), 5);
        SaleDTO saleDTO = new SaleDTO(LocalDateTime.now(), itemsInSale, 100.0, 5.0, 10.0, 95.0, 5.0);

        inventorySystem.updateInventory(saleDTO);
        try {
            ItemDTO updatedItem = inventorySystem.getItem("2");
            assertEquals(15, updatedItem.getQuantity());
        } catch (DatabaseConnectionException | ItemNotFoundException e) {
            fail("Exception was not expected");
        }
    }
}
