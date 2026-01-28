package kata.banking.lib.impl;

import kata.banking.lib.ITransition;

public class Transition implements ITransition {

    private String date;
    private int amount;
    private int balance;

    public Transition(String date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String printStatement() {

        return date 
            + "\t"
            + (amount > 0 ? "+" : "-")
            + amount 
            + "\t" + balance;
    }
    
}
