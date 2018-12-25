package com.coderbd.onlinebanking.repo;

import com.coderbd.onlinebanking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
}
