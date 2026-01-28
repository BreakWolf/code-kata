package kata.banking.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import kata.banking.lib.impl.Account;

public class AccountTests {

    @Test
    public void testAccountDeposit() {
        // Test code for deposit method
        Account account = new Account();

        account.deposit(500);
        assertTrue(account.printStatement().contains("+500\t500"));
    }

    @Test
    public void testAccountDeposit3Times() {
        // Test code for deposit method
        Account account = new Account();

        account.deposit(500);
        account.deposit(1500);
        account.deposit(5000);
        assertTrue(account.printStatement().contains("+500\t500"));
        assertTrue(account.printStatement().contains("+1500\t2000"));
        assertTrue(account.printStatement().contains("+5000\t7000"));
    }

}
