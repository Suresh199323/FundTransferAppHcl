package com.example.fundtransfer.service;

import com.example.fundtransfer.entity.User;
import com.example.fundtransfer.entity.UserTransaction;

import java.util.Date;
import java.util.List;

public interface UserService {

    public UserTransaction transferAmount(User user);
    public User create(User user);
    //public UserTran load(UserTran userTran);
    public List<UserTransaction> getAllStatements(String email);
    public List<UserTransactionByCLoseProjections> getLastWeekRecords();
   // public List<UserTransaction> getLastWeekRecords();

}
