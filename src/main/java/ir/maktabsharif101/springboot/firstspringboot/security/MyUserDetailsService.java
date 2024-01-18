package ir.maktabsharif101.springboot.firstspringboot.security;

import ir.maktabsharif101.springboot.firstspringboot.domain.User;
import ir.maktabsharif101.springboot.firstspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findByUsername(username);
        if (optionalUser.isPresent()) {
            return new MyUserDetails(optionalUser.get());
        }
        throw new UsernameNotFoundException("Bad Credentials");
    }
}
