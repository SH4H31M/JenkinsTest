package org.grid.intern.jm;

public interface AccountService {
    /**
     * It finds an account by owner id
     *
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);
    /**
     * It counts the number of account with balance > the given value
     *
     * @param value balance
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}
