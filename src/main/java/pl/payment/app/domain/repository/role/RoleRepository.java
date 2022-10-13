package pl.payment.app.domain.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.payment.app.domain.model.role.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
