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
}
