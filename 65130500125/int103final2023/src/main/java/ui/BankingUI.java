package ui;

import repository.memory.InMemoryAccountRepository;
import repository.memory.InMemoryCustomerRepository;
import service.BankingService;

public class BankingUI {
    
    private final BankingService service;
    
    public BankingUI(boolean fromFile) {
        /* if fromFile is true , load/save customer info into file */
        service = new BankingService(
                new InMemoryCustomerRepository(), 
                new InMemoryAccountRepository());
    }
    
    public void start() {
        
        /*
        [uiMenuMain()]
        write a menu for 
        1. register a customer [uiNewCustomer()]
        2. list all customers [uiMenuCustomer()]
        3. list all accounts [uiMenuAccount()]
        4. exit this menu
        
        [uiNewCustomer()] create a new customer 
        
        [uiMenuCustomer()] 
        write a menu to choose a customer or exit
        if a customer is chosen, show [uiViewCustomer()]
        
        [uiViewCustomer] show customer info and show a menu
        1. open a new account [uiNewAccount(customer)]
        2. list all accounts owned by this customer [uiMenuAccount(customer)]
        3. exit this menu

        [uiNewAccount(customer)] create a new account for the customer
        
        [uiMenuAccount()/uiMenuAccount(customer)]
        write a menu to choose an account or exit
        if an account is chosen, show [uiViewAccount()]
        
        [uiViewAccount()] show account info and show a menu
        1. deposit
        2. withdraw
        3. close
        4. exit this menu
        
        */
    }
}
