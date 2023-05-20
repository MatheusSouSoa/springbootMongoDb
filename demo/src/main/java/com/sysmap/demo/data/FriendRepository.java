package com.sysmap.demo.data;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sysmap.demo.entities.User;

public interface FriendRepository extends MongoRepository<User, UUID> {

    Optional<User> findUserByEmail(String email);
    
}
