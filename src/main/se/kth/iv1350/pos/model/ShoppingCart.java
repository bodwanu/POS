package main.se.kth.iv1350.pos.model;

import main.se.kth.iv1350.pos.dto.ItemDTO;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<ItemDTO, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    /**
     * This function adds an item and its quantity to a map, updating the quantity if the item already
     * exists in the map.
     * 
     * @param item The item parameter is an object of type ItemDTO, which represents an item that needs
     * to be added to a collection of items.
     * @param quantity The quantity parameter represents the number of items to be added to the
     * inventory for a given ItemDTO object.
     */
    public void addItem(ItemDTO item, int quantity) {
        if (items.containsKey(item)) {
            int currentQuantity = items.get(item);
            items.put(item, currentQuantity + quantity);
        } else {
            items.put(item, quantity);
        }
    }

    /**
     * This function returns a copy of a HashMap containing ItemDTO objects as keys and their
     * corresponding integer values.
     * 
     * @return A new HashMap containing a copy of the items in the original Map<ItemDTO, Integer>
     * called "items".
     */
    public Map<ItemDTO, Integer> getItems() {
        return new HashMap<>(items);
    }
}
