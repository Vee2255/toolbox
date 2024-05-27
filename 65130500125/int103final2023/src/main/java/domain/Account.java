package domain;
//65130500125
import java.io.Serializable;


public class Account implements Comparable<Account>, Serializable {
    private final String number;
    private final String ownerId;
    private double balance;
    
    public Account(String number, Customer owner) {
        /* (2.1) 
        throw InvalidAccountFormatException 
        if number is null or a blank string or owner is null */
        if(number == null || number == "" || owner == null ){
            throw new InvalidAccountFormatException("number and owner cant be null or blank")
                    }
        else{
        this.number = number;
        this.ownerId = owner.getId();
        this.balance = 0.0;
        }
        
    }
    @Override
    public String toString() {
        return String.format("Account(number:%s,ownerId:%s,balance:%f)",number,ownerId,balance);
    }
    public String getNumber() { return number; }
    public String getOwnerId() { return ownerId; }
    public double getBalance() { return balance; }
    public void deposit(double amount) { 
        /* (2.2) 
        throw InvalidAmountException if account <= 0.0 */
        if (amount <= 0.0){
            throws new InvalidAmountException("account cant less then 0.0") 
        }
        else{
        balance += amount;
        }
        
    }
    public void withdraw(double amount) {
        /* (2.3) 
        throw InvalidAmountException if account<=0.0 or amount > balance */
        if (amount <= 0.0 || amount > balance){
            throws new InvalidAmountException("account cant less then 0.0 or more then balance") 
        }
        else{
        balance -= amount;
        }
        
    }
    @Override
    public int compareTo(Account account) {
        return number.compareTo(account.number);
    }
}
