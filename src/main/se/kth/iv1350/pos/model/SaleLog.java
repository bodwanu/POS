package main.se.kth.iv1350.pos.model;

import main.se.kth.iv1350.pos.dto.SaleDTO;

import java.util.ArrayList;
import java.util.List;

public class SaleLog {
    private List<SaleDTO> completedSales;

    public SaleLog() {
        this.completedSales = new ArrayList<>();
    }

   /**
    * The function logs a completed sale by adding it to a list of completed sales.
    * 
    * @param sale
    */
    public void logSale(SaleDTO sale) {
        completedSales.add(sale);
    }

    /**
     * The function returns a list of completed sales.
     * 
     * @return A List of SaleDTO objects named "completedSales" is being returned.
     */
    public List<SaleDTO> getCompletedSales() {
        return completedSales;
    }
}
