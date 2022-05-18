package ir.lazydeveloper.serverapp.config.auth;

import ir.lazydeveloper.serverapp.model.Accessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ApplicationUser implements UserDetails {

    private final String accessorCode;
    private final String password;
    private final Set<? extends GrantedAuthority> grantedAuthorities;
    private final boolean enabled;
    private final short noOfAttempts;
    private final LocalDateTime expiryDate;
    private final int verifyCode;
    private final LocalDateTime createAt;
    private final LocalDateTime updateAt;
    private final String secondPassword;
    private final String thirdPassword;

    public ApplicationUser(Accessor accessor) {
        this.accessorCode = accessor.getAccessorCode();
        this.password = accessor.getPassword();
        this.grantedAuthorities =new HashSet<>();
        this.enabled = accessor.isEnabled();
        noOfAttempts=accessor.getNoOfAttempts();
        expiryDate= accessor.getExpiryDate();
        verifyCode=accessor.getVerifyCode();
        createAt=accessor.getCreateAt();
        updateAt=accessor.getUpdateAt();
        secondPassword=accessor.getSecondPassword();
        thirdPassword = accessor.getThirdPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return accessorCode;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public short getNoOfAttempts() {
        return noOfAttempts;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public int getVerifyCode() {
        return verifyCode;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public String getSecondPassword() {
        return secondPassword;
    }

    public String getThirdPassword() {
        return thirdPassword;
    }
}
