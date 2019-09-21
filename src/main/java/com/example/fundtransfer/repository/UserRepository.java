package com.example.fundtransfer.repository;

import com.example.fundtransfer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String emial);

    User findAllByEmail(String emial);
}

