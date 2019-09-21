package com.example.fundtransfer.repository;

import com.example.fundtransfer.entity.UserTransaction;
import com.example.fundtransfer.service.UserTransactionByCLoseProjections;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ProRepo extends CrudRepository<UserTransaction, Long> {

    //List<UserTransactionByCLoseProjections> findAllByDateAfter(Date date);

    List<UserTransactionByCLoseProjections> findAllByDateAfter(Date date);
}
