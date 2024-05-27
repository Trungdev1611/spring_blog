package com.example.Blog_model.role.respository;

import com.example.Blog_model.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRespository extends JpaRepository<Role, Long> {
    Role findByNameRole(String nameRole);
}
