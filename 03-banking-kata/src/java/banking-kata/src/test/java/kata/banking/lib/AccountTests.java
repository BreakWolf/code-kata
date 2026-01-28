package kata.banking.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import kata.banking.lib.impl.Account;

public class AccountTests {

    @Test
    public void testAccountDeposit() {
        Account account = new Account();

        account.deposit(500);
        assertTrue(account.printStatement().contains("+500\t500"));
    }

    @Test
    public void testAccountWithdraw() {
        Account account = new Account();

        account.deposit(1000);
        account.withdraw(300);
        assertTrue(account.printStatement().contains("+1000\t1000"));
        assertTrue(account.printStatement().contains("-300\t700"));
    }

    @Test
    public void testAccountWithdrawMoreThenBalance() {
        Account account = new Account();
        assertThrows(IllegalStateException.class, () ->{
            account.deposit(500);
            account.withdraw(10000);
        });
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
