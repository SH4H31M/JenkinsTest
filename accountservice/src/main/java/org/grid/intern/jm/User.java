package org.grid.intern.jm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class User {
    private final long id;
    private final String firstName;
    private final String lastName;
}
