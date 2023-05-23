package main.se.kth.iv1350.pos.dto;

/**
 * The ItemDTO class represents an item with its ID, description, price, and
 * VAT.
 */
public class ItemDTO {

    private final String itemID;
    private final String itemDescription;
    private final double itemPrice;
    private final double itemVAT;
    private int quantity;

    /**
     * ItemDTO constructor
     *
     * @param itemID          is the unique id of the item
     * @param itemDescription is the description of the item
     * @param itemPrice       is the price of the item
     * @param itemVAT         is the VAT (tax rate) of the item
     */
    public ItemDTO(String itemID, String itemDescription, double itemPrice, double itemVAT) {
        this.itemID = itemID;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemVAT = itemVAT;
        this.quantity = 0;
    }

    /**
     * Getter that retrieves id of item
     *
     * @return id of the item
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * Getter that retrieves description of item
     *
     * @return description of the item
     */
    public String getItemDescription() {
        return itemDescription;
    }

    /**
     * Getter that retrieves price of item
     *
     * @return price of the item
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * Getter that retrieves VAT of item
     *
     * @return VAT of the item
     */
    public double getItemVAT() {
        return itemVAT;
    }

    /**
     * Getter that retrieves quantity of the item
     *
     * @return quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter that sets the quantity of the item
     *
     * @param quantity the new quantity of the item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
