package com.example.dao;

import com.example.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by daiLlew on 30/09/2015.
 */
public interface UserRepository extends MongoRepository<User, String> {

	User findByFirstName(String firstName);

	List<User> findByLastName(String lastName);
}
