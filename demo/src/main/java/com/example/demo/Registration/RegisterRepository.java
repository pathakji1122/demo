package com.example.demo.Registration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends MongoRepository<Register,String> {
    Register save(Register register);
    Register findOneByEmail(String email);

}
