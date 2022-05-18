package ir.lazydeveloper.serverapp.config.auth;

import ir.lazydeveloper.serverapp.model.Accessor;
import ir.lazydeveloper.serverapp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@Service
@Transactional
public class ApplicationUserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Accessor accessor = entityManager.find(Accessor.class, username);
        if (Objects.isNull(accessor) || accessor.getAccessorCode() == null) {
            throw new UsernameNotFoundException(String.format("Username %s not found", username));
        }
        return new ApplicationUser(accessor);
    }

    public void save(Accessor accessor) {
        Role role = new Role();
        role.setRole("ADMIN");
        accessor.setPassword(passwordEncoder.encode(accessor.getPassword()));
        accessor.setRoles(Arrays.asList(role));
        entityManager.merge(accessor);
    }
}
