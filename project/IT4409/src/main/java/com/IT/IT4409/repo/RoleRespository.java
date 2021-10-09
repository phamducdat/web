package com.IT.IT4409.repo;
import com.IT.IT4409.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("roleRepository")
public interface RoleRespository extends JpaRepository<Role, Integer> {



    Role findByRole(String role);
}