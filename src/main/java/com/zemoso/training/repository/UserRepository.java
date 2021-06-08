package com.zemoso.training.repository;

import com.zemoso.training.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    //Method to find a user by username
    @Query(value = "SELECT bu FROM User bu where username = :username")
    Optional<User> findByUserName(@Param("username") String username);

}