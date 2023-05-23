package main.se.kth.iv1350.pos.view;

import main.se.kth.iv1350.pos.utils.RevenueObserver;

/**
 * This class shows the total revenue on the user interface.
 */
public class TotalRevenueView implements RevenueObserver {
    private double totalRevenue;

    @Override
    public void newSale(double revenue) {
        totalRevenue += revenue;
        System.out.println("Total revenue: " + totalRevenue);
    }
}
