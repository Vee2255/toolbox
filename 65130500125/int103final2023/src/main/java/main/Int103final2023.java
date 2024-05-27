package main;

import ui.BankingUI;

public class Int103final2023 {
    
    /* Interface/Class listing in this project.
    1. domain.Customer (* question *)
    2. domain.Account (* question *)
    3. service.BankingService (* question *)
    4. repository.CustomerRepository
    5. repository.AccountRepository
    6. repository.memory.ImMemoryCustomerRepository
    7. repository.memory.ImMemoryAccountRepository
    8. repository.file.FileCustomerRepository (* question *)
    9. ui.BankingUI (* question *)
    */

    public static void main(String[] args) {
        var app = new BankingUI(false);
        app.start();
    }
}
