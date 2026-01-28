package kata.banking.lib.impl;

import java.util.ArrayList;
import java.util.List;

import kata.banking.lib.IAccount;

public class Account implements IAccount {
    private int balance = 0;
    private List<Transition> transitions = new ArrayList<>();

    @Override
    public void deposit(int amount) {
        balance += amount;
        transitions.add(new Transition("28.01.2026", amount, balance));
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
        for (Transition transition : transitions) {
            statement.append(transition.printStatement());
            statement.append("\n");
        }
        return statement.toString();
    }

}
