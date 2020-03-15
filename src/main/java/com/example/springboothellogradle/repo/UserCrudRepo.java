package com.example.springboothellogradle.repo;

import com.example.springboothellogradle.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrudRepo extends MongoRepository<User,String> {

}
