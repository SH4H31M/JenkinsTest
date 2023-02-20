package org.grid.intern.jm;

public class Main {
    public static void main(String[] args) {

        try {
            Account[] accounts = {
                    new Account(39462908, 1328745, new User(22256231, "Anthony", "Doe")),
                    new Account(91279418, 469574, new User(96647431, "Thomas", "Blake")),
                    new Account(94290846, 187459, new User(98684431, "Anthony", "Doe")),
                    new Account(94290846, 4623273, new User(22256231, "Jekyll", "Blake")),
            };
            AccountService service = new AccountServiceImpl(accounts);
            Account found = service.findAccountByOwnerId(56231);
            if (found != null) {
                System.out.println(found);
            } else {
                System.err.println("Account does not exist!!");
            }
            long checkBal = 40000;
            System.out.println("There are " + service.countAccountsWithBalanceGreaterThan(checkBal) + " accounts with a balance greater than $" + checkBal);
        } catch (IllegalArgumentException iae) {
            System.err.println(iae.getMessage());
        }
    }
}
