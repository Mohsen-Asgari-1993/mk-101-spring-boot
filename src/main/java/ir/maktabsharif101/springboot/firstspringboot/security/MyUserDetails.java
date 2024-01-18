package ir.maktabsharif101.springboot.firstspringboot.security;

import ir.maktabsharif101.springboot.firstspringboot.domain.User;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MyUserDetails implements UserDetails {

    private final User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(user.getRoles())) {
            user.getRoles().forEach(
                    role -> {
                        if (CollectionUtils.isNotEmpty(role.getPermissions())) {
                            role.getPermissions().forEach(
                                    permission ->
                                            authorities.add(
                                                    new SimpleGrantedAuthority(permission.getName())
                                            )
                            );
                        }
                    }
            );
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getIsActive();
    }

    public User getUser() {
        return user;
    }
}
