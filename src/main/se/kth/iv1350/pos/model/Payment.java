package main.se.kth.iv1350.pos.model;

public class Payment {
    private final double amountPaid;
    private final double change;

    public Payment(double amountPaid, double totalPrice) {
        this.amountPaid = amountPaid;
        this.change = amountPaid - totalPrice;
    }

    /**
     * The function returns the amount paid as a double.
     * 
     * @return The method is returning a double value which represents the amount paid.
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * The function returns the value of the "change" variable as a double data type.
     * 
     * @return The method `getChange()` is returning a `double` value which represents the change.
     */
    public double getChange() {
        return change;
    }
}
