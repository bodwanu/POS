package main.se.kth.iv1350.pos.utils;

/**
 * This class writes the total revenue to a file.
 */
public class TotalRevenueFileOutput implements RevenueObserver {
    private double totalRevenue;
    private FileLogger fileLogger;

    public TotalRevenueFileOutput() {
        this.fileLogger = new FileLogger();
    }

    @Override
    public void newSale(double revenue) {
        totalRevenue += revenue;
        fileLogger.log("Total revenue: " + totalRevenue);
    }
}
