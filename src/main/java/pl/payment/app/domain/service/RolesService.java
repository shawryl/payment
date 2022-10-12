package pl.payment.app.domain.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.payment.app.domain.model.Roles;
import pl.payment.app.domain.repository.RoleRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class RolesService {
    RoleRepository roleRepository;

    @Transactional
    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    @Transactional
    public Roles getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role with id:" + id + " not found."));
    }

    @Transactional
    public Roles addRole(Roles role) {
        return roleRepository.saveAndFlush(role);
    }

    @Transactional
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
