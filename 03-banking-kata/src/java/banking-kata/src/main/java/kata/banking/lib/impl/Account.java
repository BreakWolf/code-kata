package kata.banking.lib.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import kata.banking.lib.IAccount;

public class Account implements IAccount {
    private int balance = 0;
    private List<Transition> transitions = new ArrayList<>();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    public void deposit(int amount) {
        balance += amount;
        String currentDate = getCurrentDate();

        transitions.add(new Transition(currentDate, amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        balance -= amount;
        transitions.add(new Transition(getCurrentDate(), amount * -1, balance));
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

    private String getCurrentDate() {
        String currentDate = LocalDate.now().format(DATE_FORMATTER);
        return currentDate;
    }

}
