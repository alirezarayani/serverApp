package ir.lazydeveloper.serverapp.config.auth;

import ir.lazydeveloper.serverapp.model.Accessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
public class AccessorService {

    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public AccessorService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<ApplicationUser> getUserByUsername(String accessorCode) {
        Accessor accessor = entityManager.find(Accessor.class, accessorCode);
        return Optional.of(new ApplicationUser(accessor));
    }

    public void save(Accessor accessor) {
        accessor.setPassword(passwordEncoder.encode(accessor.getPassword()));
        entityManager.persist(accessor);
    }
}
