package com.github.arix3767.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    @Setter(AccessLevel.PRIVATE)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column()
    private String password;
}
