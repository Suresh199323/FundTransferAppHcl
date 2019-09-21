package com.example.fundtransfer.util;

import com.example.fundtransfer.entity.User;
import com.example.fundtransfer.pvo.UserPVO;

public class PVOUtil {


    public static final User createNew(final UserPVO userPVO ){
        if (userPVO == null) {
            return null;
        }


        User user = new User();
        user.setEmail(userPVO.getEmail());
        user.setAddress(userPVO.getAddress());
        user.setAmount(userPVO.getAmount());
        user.setAge(userPVO.getAge());
        user.setName(userPVO.getName());

        return user;

    }
}
