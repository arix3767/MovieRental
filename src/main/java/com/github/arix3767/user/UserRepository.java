package com.github.arix3767.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface UserRepository extends JpaRepository<User, UUID> {

    boolean existByEmail(String email);
    Optional<User> findByEmail(String email);
    @Query("")
    UUID findIdByEmail(String email);
}
