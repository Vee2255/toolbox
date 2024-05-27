package repository.memory;

import domain.Account;
import domain.Customer;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import repository.AccountRepository;

public class InMemoryAccountRepository implements AccountRepository {
    
    private long nextAccountNumber = 1;
    private final Map<String,Account> repo;

    public InMemoryAccountRepository() { repo = new TreeMap<>(); }

    @Override
    public Account retrieve(String number) {
        return repo.get(number);
    }

    @Override
    public Account create(Customer owner) {
        if (owner == null) return null;
        var number = String.format("A%011d", nextAccountNumber);
        if (repo.containsKey(number)) return null;
        var account = new Account(number, owner);
        repo.put(number, account);
        ++nextAccountNumber;
        return account;
    }

    @Override
    public boolean update(Account account) {
        if (account == null) return false;
        repo.replace(account.getNumber(), account);
        return true;
    }

    @Override
    public boolean delete(Account account) {
        if (account == null) return false;
        return repo.remove(account.getNumber(),account);
    }
    
    @Override
    public Stream<Account> stream() { return repo.values().stream(); }
}
