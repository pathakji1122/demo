package com.example.demo.Return;

import com.example.demo.Auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service

public class ReturnedService {
    @Autowired
    ReturnedRepository returnedRepository;

          public ReturnedUser getData(String mail){
              ReturnedUser returnedUser = returnedRepository.findOneByEmail(mail);
              return returnedUser;
          }
        //ReturnedRepository returnedRepository;


}
