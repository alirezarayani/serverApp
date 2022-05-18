package ir.lazydeveloper.serverapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Accessor {
    @Id
    @Column(nullable = false, insertable = false, updatable = false, unique = true)
    private String accessorCode;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean enabled;
    private short NoOfAttempts;
    private LocalDateTime expiryDate;
    private int verifyCode;
    @CreationTimestamp
    private LocalDateTime createAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
    private String secondPassword;
    private String thirdPassword;

    @ManyToMany()
    @JoinTable(
            name = "party_role",
            joinColumns = @JoinColumn(name = "accessor_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
