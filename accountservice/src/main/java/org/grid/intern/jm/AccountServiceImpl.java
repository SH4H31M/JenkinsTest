package org.grid.intern.jm;

// Declare and implement your AccountServiceImpl here
class AccountServiceImpl implements AccountService {

    private final Account[] accounts;

    public AccountServiceImpl(Account[] accounts) {
        this.accounts = accounts;
        findDuplicates(accounts);
    }

    private void findDuplicates(Account[] accounts) {
        StringBuilder accountsErrorMsg = new StringBuilder();
        StringBuilder usersErrorMsg = new StringBuilder();
        for (int i = 0; i < accounts.length; i++) {
            long accountId = accounts[i].getId();
            for (int j = i + 1; j < accounts.length; j++) {
                if (accountId == accounts[j].getId()) {
                    accountsErrorMsg.append(String.format("Duplicate Account ID: %d at indices [%d] and [%d]\n", accountId, i, j));
                }
                long userId = accounts[i].getOwner().getId();
                if (userId == accounts[j].getOwner().getId()) {
                    usersErrorMsg.append(String.format("Duplicate User ID: %d at indices [%d] and [%d]\n", userId, i, j));
                }
            }
        }
        String errorMessage = String.valueOf(accountsErrorMsg) + usersErrorMsg;
        if (errorMessage.length() > 0) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        for (Account account : accounts) {
            if (account.getOwner().getId() == id) {
                return account;
            }
        }
        return null;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        long count = 0;
        for (Account account : accounts) {
            if (account.getBalance() > value) {
                count += 1;
            }
        }
        return count;
    }
}
