 Account Service (Interfaces)

Imagine an interface AccountService that is designed for keeping track of accounts and balances.

It has two abstract methods:

findAccountByOwnerId(long id) takes user id and returns this user account or null in case no account was found;

countAccountsWithBalanceGreaterThan(long balance) returns the number of accounts with a balance exceeding the provided number.

There are also two classes: Account and User, each of them having several fields. 
The owner field of the Account class is an object of the User type. 
You can find the details in the provided template.

Your task is to create an AccountServiceImpl class that implements the AccountService interface and its two methods.

It should have a constructor that takes an Account array which will be used for searching when either of the methods is called.

For example, to find an account by the user id we need to go through all the accounts from this array and compare these accounts owners id with the given id.

Here's an example of how these methods will be called:

Account[] accounts = ...
AccountService service = new AccountServiceImpl(accounts);
service.findAccountByOwnerId(10L); // returns an account where owner id is 10

Note: do not make classes and the interface public.


Template:

interface AccountService {
  /**
   * It finds an account by owner id
   * @param id owner unique identifier
   * @return account or null
   */
  Account findAccountByOwnerId(long id);
  /**
   * It count the number of account with balance > the given value
   * @param value
   * @return the number of accounts
   */
  long countAccountsWithBalanceGreaterThan(long value);
}

// Declare and implement your AccountServiceImpl here

class Account {

  private long id;
  private long balance;
  private User owner;

  public Account(long id, long balance, User owner) {
      this.id = id;
      this.balance = balance;
      this.owner = owner;
  }

  public long getId() {
      return id;
  }

  public long getBalance() {
      return balance;
  }

  public User getOwner() {
      return owner;
  }
}

class User {

  private long id;
  private String firstName;
  private String lastName;

  public User(long id, String firstName, String lastName) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
  }

  public long getId() {
      return id;
  }

  public String getFirstName() {
      return firstName;
  }

  public String getLastName() {
      return lastName;
  }
}