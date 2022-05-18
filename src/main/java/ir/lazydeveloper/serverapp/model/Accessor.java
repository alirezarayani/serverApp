package ir.lazydeveloper.serverapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String accessorCode;
    private String password;
    private boolean enabled;
    private short NoOfAttempts;
    private LocalDateTime expiryDate;
    private int verifyCode;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String secondPassword;
    private String thirdPassword;

    @ManyToMany()
    @JoinTable(
            name = "party_role",
            joinColumns =  @JoinColumn(name = "party_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
