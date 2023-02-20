package org.grid.intern.jm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Account {
    private final long id;
    private final long balance;
    private final User owner;
}
