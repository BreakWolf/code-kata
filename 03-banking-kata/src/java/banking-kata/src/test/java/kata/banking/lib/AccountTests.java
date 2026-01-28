package kata.banking.lib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import kata.banking.lib.impl.Account;

public class AccountTests {

    private Account _account = new Account();

    @Test
    public void testAccountDeposit() {
        _account.deposit(500);
        assertTrue(_account.printStatement().contains("+500\t500"));
    }

    @Test
    public void testAccountWithdraw() {

        _account.deposit(1000);
        _account.withdraw(300);

        assertTrue(_account.printStatement().contains("+1000\t1000"));
        assertTrue(_account.printStatement().contains("-300\t700"));
    }

    @Test
    public void testAccountWithdrawMoreThenBalance() {
        assertThrows(IllegalStateException.class, () ->{
            _account.deposit(500);
            _account.withdraw(10000);
        });

        assertTrue(_account.printStatement().contains("+500\t500"));
    }    

    @Test
    public void testAccountDeposit3Times() {

        _account.deposit(500);
        _account.deposit(1500);
        _account.deposit(5000);

        assertTrue(_account.printStatement().contains("+500\t500"));
        assertTrue(_account.printStatement().contains("+1500\t2000"));
        assertTrue(_account.printStatement().contains("+5000\t7000"));
    }

}
