package com.example.fundtransfer.repository;

import com.example.fundtransfer.entity.UserTransaction;
import com.example.fundtransfer.service.UserTransactionByCLoseProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Transactional
public interface TransactionRepository extends JpaRepository<UserTransaction, Long> {

    UserTransaction findByEmail(String email);
   List<UserTransaction> findFirst10ByEmail(String email);
  // List <UserTransaction> findAllByDateAfter1(Date date);


   //@Query("select p from Person p where p.firstName = ?1")
   //@Query(value = "SELECT name FROM user_tran", nativeQuery = true)
   // List <UserTransactionByCLoseProjections> findAllByDateAfter(Date date);

   // List<UserTransactionByCLoseProjections> findByDate();
}