package com.mydbs.insurance.insurance_management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mydbs.insurance.insurance_management.model.User;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByRoles(String roles);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<User> findByRolesContainingAndEnabled(String roles, boolean enabled);
}