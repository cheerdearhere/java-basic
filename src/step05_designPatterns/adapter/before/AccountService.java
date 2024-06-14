package step05_designPatterns.adapter.before;

public class AccountService {
    public Account findAccountByUsername(String username) {
        Account account = new Account();
        account.setName(username);
        account.setPassword(username);
        account.setEmail(username);
        return account;
    }

    public void createAccount(Account account) {}
    public void updateAccount(Account account) {}
}
