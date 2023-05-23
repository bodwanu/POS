package main.se.kth.iv1350.pos.integration;

/**
 * The `Register` class represents an account balance and provides methods to update and retrieve the
 * balance.
 */
public class Register {
    private double balance;

    public Register(double initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * The function updates the balance by adding a given amount.
     * 
     * @param amount The parameter "amount" is a double data type representing the amount by which the
     * balance needs to be updated. 
     */
    public void updateBalance(double amount) {
        balance += amount;
    }

    /**
     * The function returns the balance of an account as a double data type.
     * 
     * @return The method `getBalance()` is returning the value of the `balance` variable, which is a
     * `double` data type.
     */
    public double getBalance() {
        return balance;
    }
}
