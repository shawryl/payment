package pl.payment.app.web;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.payment.app.domain.model.Roles;
import pl.payment.app.domain.service.RolesService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class RoleController {
    RolesService rolesService;

    @GetMapping("/list")
    @PreAuthorize("permitAll")
    public ResponseEntity getRoles() {
        return new ResponseEntity(rolesService.getAllRoles(), HttpStatus.OK);
    }
    
    @GetMapping("/role/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity getRoleById(@PathVariable Long id) {
        return new ResponseEntity(rolesService.getRoleById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("permitAll")
    public ResponseEntity addRole(@RequestBody Roles role) {
        return new ResponseEntity(rolesService.addRole(role), HttpStatus.OK);
    }

    @DeleteMapping("/role/{id}")
    @PreAuthorize("permitAll")
    public ResponseEntity deleteRole(@PathVariable Long id) {
        rolesService.deleteRole(id);

        return new ResponseEntity("Role with id " + id + " has been deleted successfully.", HttpStatus.OK);
    }


}
