/*
package ir.maktabsharif101.springboot.firstspringboot.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {

        return new InMemoryUserDetailsManager(
                List.of(
                        User.builder()
                                .username("mohsen")
                                .password("123456789")
                                .build(),

                        User.builder()
                                .username("ali")
                                .password("987654321")
                                .build(),

                        User.builder()
                                .username("mahdi")
                                .password("654321987")
                                .build()

                )
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
*/
