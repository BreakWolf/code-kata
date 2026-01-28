package kata.banking.lib;

public interface IAccount {
    void deposit(int amount);
    void withdraw(int amount);
    String printStatement();
}
