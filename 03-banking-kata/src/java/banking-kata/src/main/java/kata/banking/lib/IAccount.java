package kata.banking.lib;

public interface IAccount {
    /*
     * Deposit an amount into the account.
     */
    void deposit(int amount);

    /*
     * Withdraw an amount from the account.
     */
    void withdraw(int amount);

    /*
     * Print the account statement.
     */
    String printStatement();
}
