package repository;

import domain.Customer;
import java.util.stream.Stream;

public interface CustomerRepository {
    public Customer retrieve(String id);
    public Customer create(String name);
    public boolean update(Customer customer);
    public Stream<Customer> stream();
}
