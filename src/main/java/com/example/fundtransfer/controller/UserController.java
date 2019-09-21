package com.example.fundtransfer.controller;

import com.example.fundtransfer.entity.User;
import com.example.fundtransfer.entity.UserTransaction;
import com.example.fundtransfer.pvo.UserPVO;
import com.example.fundtransfer.repository.UserRepository;
import com.example.fundtransfer.service.UserService;
import com.example.fundtransfer.service.UserTransactionByCLoseProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/user")
    public class UserController {

      private UserRepository userRepository;
      private UserService userService;


    //  @Autowired
        public UserController(UserRepository userRepository, UserService userService) {
           this.userRepository = userRepository;
           this.userService=userService;

        }

    @PostMapping(value = "/save")
    public ResponseEntity<User> saveUSer(@RequestBody User user){
        return new ResponseEntity<User>(userService.create(user), HttpStatus.CREATED);
       // userService.create(user);
    }


       @PostMapping(value = "/transfer")
           public ResponseEntity<UserTransaction> transferAmount(@RequestBody  User user) {
              return new ResponseEntity(userService.transferAmount(user),HttpStatus.OK);
              //  return new HttpStatus("OK");
        }


     @GetMapping(value = "/getlastWeekrecords")
        public ResponseEntity<List<UserTransactionByCLoseProjections>> lastWeekRecords() {

         return new ResponseEntity<List<UserTransactionByCLoseProjections>>(userService.getLastWeekRecords(), HttpStatus.OK);

        }

        @GetMapping(value = "getlasttenstatements")
        public ResponseEntity<List>lastTenStatements(@RequestParam String email)
        {
            /*return  userService.getAllStatements(email);*/
            return new ResponseEntity<List>(userService.getAllStatements(email), HttpStatus.OK);
        }
    }

