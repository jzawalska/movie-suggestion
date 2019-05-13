package com.moviesuggestion.model.user;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByFirstName(String firstName);

    List<User> findByLogin(String login);

}
