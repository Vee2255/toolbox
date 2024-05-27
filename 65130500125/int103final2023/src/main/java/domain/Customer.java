package domain;
//65130500125
import java.io.Serializable;

public class Customer implements Comparable<Customer>, Serializable {
    private final String id;
    private String name;
    
    public Customer(String id, String name) {
        /* (1.1) 
        throw InvalidCustomerFormatException 
        if id or name is null or a blank string */
        
        if(name == null || name == "" || id == null || id == ""){
            throw new InvalidCustomerFormatException("name and id cant be null or blank")
                    }
        else{
        this.id = id;
        this.name = name;
        }
    }
    @Override
    public String toString() {
        return String.format("Customer(id:%s,name:%s)",id,name);
    }
    public String getId() { return id; }
    public String getName() { return name; }

    /* (1.2)
    throw InvalidCustomerFormatException 
    if name is null or a blank string */
    static void checkName(String name){
    if(name == null || name == "" ){
            throw new InvalidCustomerFormatException("name cant be null or blank")
        }
 
    }
    public void rename(String name) { this.name = name; }
    
    @Override
    public int compareTo(Customer customer) {
        return id.compareTo(customer.id);
    }
}
