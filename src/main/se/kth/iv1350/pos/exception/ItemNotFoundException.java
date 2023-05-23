package main.se.kth.iv1350.pos.exception;

public class ItemNotFoundException extends Exception {

    private final String itemId;

    public ItemNotFoundException(String itemId) {
        super("Item with id: " + itemId + " not found in the inventory catalog.");
        this.itemId = itemId;
    }

    public String getItemId() {
        return this.itemId;
    }
}
