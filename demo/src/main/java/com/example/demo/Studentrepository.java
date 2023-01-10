package com.example.demo;

import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface Studentrepository extends MongoRepository<Student, Integer> {



}
