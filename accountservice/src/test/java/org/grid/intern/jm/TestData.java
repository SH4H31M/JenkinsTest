package org.grid.intern.jm;

import java.util.function.Supplier;

public interface TestData {
    Supplier<Account[]> getTestData = () -> new Account[]{
            new Account(33542908, 18745, new User(47873831, "Anthony", "Doe")),
            new Account(23413090, 13273, new User(89423831, "Jekyll", "Blake")),
            new Account(23663090, 689579, new User(89534789, "Rowan", "Creed")),
            new Account(55413896, 79570, new User(13234703, "Maria", "Jones")),
            new Account(99813090, 9069578, new User(98870932, "Rowena", "Bloom")),
    };
    Supplier<AccountService> getService = ()-> new AccountServiceImpl(getTestData.get());
    AccountService service = getService.get();
}
