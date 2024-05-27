package com.example.Blog_model.user.respository;

import com.example.Blog_model.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username); //rely on the way specific name for method in JPA

    Optional<User> findByUsername(String username);
}
