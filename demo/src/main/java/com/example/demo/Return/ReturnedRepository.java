package com.example.demo.Return;

import com.example.demo.Auth.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnedRepository extends MongoRepository<ReturnedUser,String > {
    ReturnedUser findOneByEmail(String email);
    ReturnedUser save(ReturnedUser returnedUser);
}
