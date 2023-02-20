package org.grid.intern.jm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class AccountServiceTest implements TestData {
    @Test
//    @Description("Test retrieve an account if found by id")
//    @Step("1")
    public void testReturnsAccountIfFound() {
        Account found = service.findAccountByOwnerId(89534789);
        Assertions.assertNotNull(found, "Account not Found");
    }

    @Test
//    @Description("Returns null if account not found")
//    @Step("2")
    public void testReturnsNullIfAccountNotFound() {
        Account found = service.findAccountByOwnerId(9981090);
        Assertions.assertNull(found, "Account found");
    }

    @Test
//    @Description("Test count equals zero when no accounts found exceeding query bal")
//    @Step("3")
    public void testReturnsZeroIfNoAccountsFoundExceedingBalance() {
        Assertions.assertEquals(0, service.countAccountsWithBalanceGreaterThan(80000000));
    }

    @Test
//    @Description("Test return number of accounts found exceeding query bal")
//    @Step("4")
    public void testReturnsNumberOfAccountsFoundExceedingBalance() {
        Assertions.assertEquals(4, service.countAccountsWithBalanceGreaterThan(16000));
    }

    @Test
//    @Description("Test return number of accounts found exceeding query bal")
//    @Step("5")
    public void testReturnsAccountsFoundExceedingBalance() {
        Assertions.assertEquals(3, service.countAccountsWithBalanceGreaterThan(20000));
    }

    @Test
//    @Description("Test that Illegal argument exception thrown for duplicate account ids")
//    @Step("6")
    public void testThrowsIllegalArgumentExceptionDuplicateAccountIds() {
        Account[] duplicateAccountIDSet = new Account[]{
                new Account(23862890, 469574, new User(56878452, "Thomas", "Blake")),
                new Account(41374278, 18745, new User(48538389, "Anthony", "Doe")),
                new Account(23862890, 4623273, new User(76243831, "Jekyll", "Blake")),
        };
        Exception exception = assertThrowsExactly(IllegalArgumentException.class, () -> new AccountServiceImpl(duplicateAccountIDSet));
        System.out.println(exception.getMessage());
        assertEquals("  Duplicate Account ID: 23862890 at indices [0] and [2]".trim(), exception.getMessage().trim());
    }

    @Test
//    @Description("Test that Illegal argument exception thrown for duplicate user ids")
//    @Step("7")
    public void testThrowsIllegalArgumentExceptionDuplicateUserIds() {
        Account[] duplicateUserIDSet = new Account[]{
                new Account(37653408, 1328745, new User(89568831, "Anthony", "Doe")),
                new Account(39429308, 18745, new User(48923832, "Bailey", "Holmer")),
                new Account(23496090, 4623273, new User(48923832, "Mina", "Jokil")),
        };
        Exception exception = assertThrowsExactly(IllegalArgumentException.class, () -> new AccountServiceImpl(duplicateUserIDSet));
        assertEquals("Duplicate User ID: 48923832 at indices [1] and [2]".trim(), exception.getMessage().trim());
    }

    @Test
//    @Description("Test that Illegal argument exception thrown for duplicate account and duplicate user ids")
//    @Step("8")
    public void testThrowsIllegalArgumentExceptionDuplicateAccountandUserIds() {
        Account[] duplicateIDSet = new Account[]{
                new Account(33542908, 1328745, new User(23659034, "Anthony", "Doe")),
                new Account(23862890, 469574, new User(87886324, "Thomas", "Blake")),
                new Account(33542908, 18745, new User(87886324, "Anthony", "Doe")),
        };
        Exception exception = assertThrowsExactly(IllegalArgumentException.class, () -> new AccountServiceImpl(duplicateIDSet));
        String expected = "Duplicate Account ID: 33542908 at indices [0] and [2]\nDuplicate User ID: 87886324 at indices [1] and [2]";
        assertEquals(expected.trim(), exception.getMessage().trim());
    }
}
