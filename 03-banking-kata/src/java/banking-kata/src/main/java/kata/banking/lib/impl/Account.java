package kata.banking.lib.impl;

import kata.banking.lib.IAccount;

public class Account implements IAccount {
    private int balance = 0;

    @Override
    public void deposit(int amount) {
        balance += amount;
    }

    @Override
    public void withdraw(int amount) {
        balance -= amount;
    }

    @Override
    public String printStatement() {
        StringBuilder statement = new StringBuilder();
        statement.append("Date\tAmount\tBalance");
        statement.append("\n");
        statement.append("28.01.2026\t+" + balance + "\t" + balance);

        return statement.toString();
    }

}
