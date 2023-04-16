package com.github.arix3767.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface UserRepository extends JpaRepository<UserEntity, UUID> {

    boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
    @Query(value = "select u.id from UserEntity u where u.email = :email")
    UUID findIdByEmail(@Param("email")String email);
}
