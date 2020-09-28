package com.login.login.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<DBUser, Long> {
    Optional<DBUser> findByName(String name);
}
