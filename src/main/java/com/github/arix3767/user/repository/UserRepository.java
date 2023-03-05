package com.github.arix3767.user.repository;

import com.github.arix3767.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existByEmail(String email);

}
