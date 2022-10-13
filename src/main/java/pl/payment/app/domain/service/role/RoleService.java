package pl.payment.app.domain.service.role;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.payment.app.domain.model.role.Role;
import pl.payment.app.domain.repository.role.RoleRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Transactional
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role with id:" + id + " not found."));
    }

    @Transactional
    public Role addRole(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Transactional
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
