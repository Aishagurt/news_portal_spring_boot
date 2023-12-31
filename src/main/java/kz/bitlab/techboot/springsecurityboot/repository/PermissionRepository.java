package kz.bitlab.techboot.springsecurityboot.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.techboot.springsecurityboot.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByRole(String role);
}
