package repository.memory;

import domain.Customer;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import repository.CustomerRepository;

public class InMemoryCustomerRepository implements CustomerRepository {
    
    private long nextCustomerId = 1;
    private final Map<String,Customer> repo;

    public InMemoryCustomerRepository() { this.repo = new TreeMap<>(); }

    @Override
    public Customer create(String name) {
        var id = String.format("C%011d", nextCustomerId);
        if (repo.containsKey(id)) return null;
        var customer = new Customer(id,name);
        repo.put(id, customer);
        ++nextCustomerId;
        return customer;
    }

    @Override
    public boolean update(Customer customer) {
        if (customer == null) return false;
        repo.replace(customer.getId(), customer);
        return true;
    }

    @Override
    public Customer retrieve(String id) {
        if (id == null) return null;
        return repo.get(id);
    }

    @Override
    public Stream<Customer> stream() { return repo.values().stream(); }
}
