package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.exception.UsernameAlreadyExistsException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    //register account
    public Account register(Account account) throws Exception {
        if(account.getUsername() == null || account.getUsername().isBlank()){
            throw new Exception("no user name");
        }
        if(account.getPassword() == null || account.getPassword().length() <4){
            throw new Exception("to small password");
        }
        
        Optional<Account> existingAccount = accountRepository.findByUsername(account.getUsername());
        if(existingAccount.isPresent()){
            throw new UsernameAlreadyExistsException("account exists");
        }
        return accountRepository.save(account);
    }
}
