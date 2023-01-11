package com.example.demo;

import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface Studentrepository extends MongoRepository<Student, Integer> {
    Optional<Student> findByEnrollno(int enrollno);
    Boolean existsbyname(String name);
    Boolean existsbyenrollno(Integer enrollno);

}
