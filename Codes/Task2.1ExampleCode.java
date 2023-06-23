public class BankService {
    private AccountDAO accountDao;
    private TransactionDAO transactionDao;
    private AuthenticationService authService;

    // Constructor injection
    public BankService(AccountDAO accountDao, TransactionDAO transactionDao, AuthenticationService authService) {
        this.accountDao = accountDao;
        this.transactionDao = transactionDao;
        this.authService = authService;
    }

    public void transferMoney(String fromAccount, String toAccount, double amount) throws InsufficientFundsException {
        // Authenticate the user
        User user = authService.authenticate();
        if (user == null) {
            throw new UnauthorizedAccessException();
        }

        // Retrieve the accounts
        Account from = accountDao.getAccount(fromAccount);
        Account to = accountDao.getAccount(toAccount);

        // Check for sufficient funds
        if (from.getBalance() < amount) {
            throw new InsufficientFundsException();
        }

        // Perform the transaction
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        transactionDao.createTransaction(from, to, amount);
    }
}
