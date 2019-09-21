package com.example.fundtransfer.manager;

import com.example.fundtransfer.entity.User;
import com.example.fundtransfer.entity.UserTransaction;
import com.example.fundtransfer.repository.ProRepo;
import com.example.fundtransfer.repository.TransactionRepository;
import com.example.fundtransfer.repository.UserRepository;
import com.example.fundtransfer.service.UserService;
import com.example.fundtransfer.service.UserTransactionByCLoseProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class UserManager implements UserService {

    private UserRepository userRepository;
    private TransactionRepository transactionRepository;
    @Autowired
    ProRepo proRepo;

    // @Autowired
    public UserManager(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }


    //UserTran userTran;
    UserTransaction userTransaction = new UserTransaction();
    User toUser;
    long requestedAmount;


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public UserTransaction transferAmount(User user) {
// transferring amount toUSer
        toUser = userRepository.findByEmail(user.getEmail());
        long currentBalance = toUser.getAmount();
        requestedAmount = user.getAmount();
        toUser.setAmount(currentBalance + requestedAmount);

        userRepository.save(toUser);

// transferring amount fromUser
        User fromUser = userRepository.findByEmail("schand0276@gmail.com");
        long remainingBalanceFromUser = fromUser.getAmount() - requestedAmount;
        fromUser.setAmount(remainingBalanceFromUser);
        userRepository.save(fromUser);

        //saving into user_tran table
        userTransaction.setEmail(toUser.getEmail());
        userTransaction.setName(toUser.getName());
        userTransaction.setDate(user.getDate());
        userTransaction.setAge(toUser.getAge());
        userTransaction.setAddress(toUser.getAddress());
        userTransaction.setAccountNumber(toUser.getAccountNumber());
        userTransaction.setTransAmount(requestedAmount);
        // for oneToMany Relationship
        // Set set=  toUser.getUserTrans();
        // set.add(userTran);
       return transactionRepository.saveAndFlush(userTransaction);
    }

    public User create(User user) {
        Random rand = new Random();
        Double rand_int1 = rand.nextDouble();

        user.setAccountNumber(rand_int1);
       return userRepository.save(user);
    }

    @Override
    public List<UserTransaction> getAllStatements(String email) {

        return transactionRepository.findFirst10ByEmail(email);
    }

    @Override
    public List<UserTransactionByCLoseProjections> getLastWeekRecords() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

      // substract 7 days
      // If we give 7 there it will give 8 days back
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-6);

        // convert to date
        Date myDate = cal.getTime();
        return proRepo.findAllByDateAfter(myDate);
    }

   /* @Override
    public List<UserTransactionByCLoseProjections> getLastWeekRecords1() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        // substract 7 days
        // If we give 7 there it will give 8 days back
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) - 6);

        // convert to date
        Date myDate = cal.getTime();
        return proRepo.findAllByDateAfter(myDate);
    }*/
}
