package repository.file;

import domain.Customer;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import repository.CustomerRepository;

public class FileCustomerRepository implements CustomerRepository {
    
    private String filename = "customers.dat";
    private long nextCustomerId;
    private Map<String,Customer> repo;

    public FileCustomerRepository() { 
        /* 8.1
        if the file exists, 
           open the file with buffer 
           (using FileInputStream, BufferedInputStream, ObjectInputStream)
           read nextCustomerId, and repo from the file
        else set nextCustomerId = 1 and set repo to a new TreeMap.
        
        8.2-8.5 are similar to InMemoryCustomerRepository 
        but when repo changes, always writes nextCustomerId and repo to the file
        (using FileOutputStream, BufferedOutputStream, ObjectOutputStream)
        */
    }

  

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
