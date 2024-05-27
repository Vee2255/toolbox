package repository;

import domain.Account;
import domain.Customer;
import java.util.stream.Stream;

public interface AccountRepository {
    public Account retrieve(String number);
    public Account create(Customer owner);
    public boolean update(Account account);
    public boolean delete(Account account);
    public Stream<Account> stream();
}
