package service;
//65130500125
import domain.Account;
import domain.Customer;
import java.util.stream.Stream;
import repository.AccountRepository;
import repository.CustomerRepository;

public class BankingService {
    private final CustomerRepository customerRepo;
    private final AccountRepository accountRepo;

    public BankingService(CustomerRepository customerRepo, AccountRepository accountRepo) {
        this.customerRepo = customerRepo;
        this.accountRepo = accountRepo;
    }

    public Customer registerCustomer(String name) {
        return customerRepo.create(name);
    }

    public Account openAccount(String customerId) {
        var customer = customerRepo.retrieve(customerId);
        if (customer == null) return null;
        return accountRepo.create(customer);
    }

    public boolean closeAccount(String accountNumber) {
        var account = accountRepo.retrieve(accountNumber);
        if (account == null) return false;
        return accountRepo.delete(account);
    }

    public boolean deposit(String accountNumber, double amount) {
        var account = accountRepo.retrieve(accountNumber);
        if (account == null) return false;
        account.deposit(amount);
        return accountRepo.update(account);
    }

    public boolean withdraw(String accountNumber, double amount) {
        var account = accountRepo.retrieve(accountNumber);
        if (account == null) return false;
        account.withdraw(amount);
        return accountRepo.update(account);
    }

    public Customer getCustomer(String customerId) {
        return customerRepo.retrieve(customerId);
    }

    public Account getAccount(String accountNumber) {
        return accountRepo.retrieve(accountNumber);
    }

    public Stream<Customer> getCustomers() {
        return customerRepo.stream();
    }
    public Stream<Account> getAccounts() {
        return accountRepo.stream();
    }
    public Stream<Account> getAccountsByCustomer(String customerId) {
        /* 3.1
        return an empty stream if customerId is null,
        otherwise return a stream of accounts owned by the customer */
        if (customerId == null){
           
        return accountRepo.stream();
        }
        else{
         return accountRepo.stream();
        }
       
    }
}
