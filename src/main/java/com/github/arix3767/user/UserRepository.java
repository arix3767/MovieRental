package com.github.arix3767.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UserRepository extends JpaRepository<User, Long> {

    boolean existByEmail(String email);

    Optional<User> findByEmail(String email);
}
