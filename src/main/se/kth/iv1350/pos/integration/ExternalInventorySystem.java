package main.se.kth.iv1350.pos.integration;

import main.se.kth.iv1350.pos.dto.ItemDTO;
import main.se.kth.iv1350.pos.dto.SaleDTO;
import main.se.kth.iv1350.pos.exception.DatabaseConnectionException;
import main.se.kth.iv1350.pos.exception.ItemNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class ExternalInventorySystem {
    private HashMap<String, ItemDTO> items;

    public ExternalInventorySystem() {
        items = new HashMap<>();
        items.put("1", new ItemDTO("1", "Banana", 10, 0.25));
        items.put("2", new ItemDTO("2", "Mango", 20, 0.25));
        items.put("3", new ItemDTO("3", "Apple", 10, 0.20));
    }

    public ItemDTO getItem(String itemID) throws ItemNotFoundException, DatabaseConnectionException {
        if (itemID.equals("999")) {
            throw new DatabaseConnectionException("InventoryDatabase");
        }

        ItemDTO item = items.get(itemID);

        if (item == null) {
            throw new ItemNotFoundException(itemID);
        }

        return item;
    }


    public void updateInventory(SaleDTO saleDTO) {
        for (Map.Entry<ItemDTO, Integer> entry : saleDTO.getItemsInCurrentSale().entrySet()) {
            ItemDTO itemSold = entry.getKey();
            int quantitySold = entry.getValue();
            ItemDTO currentItem = items.get(itemSold.getItemID());
            currentItem.setQuantity(currentItem.getQuantity() - quantitySold);
        }
    }
}
