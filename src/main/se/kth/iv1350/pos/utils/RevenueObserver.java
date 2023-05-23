package main.se.kth.iv1350.pos.utils;

/**
 * An observer interface for receiving notifications about the total revenue.
 */
public interface RevenueObserver {
    /**
     * Invoked when a sale has been paid.
     *
     * @param revenue The total revenue after the sale has been paid.
     */
    void newSale(double revenue);
}
