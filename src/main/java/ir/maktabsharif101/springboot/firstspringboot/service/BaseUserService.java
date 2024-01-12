package ir.maktabsharif101.springboot.firstspringboot.service;

import ir.maktabsharif101.springboot.firstspringboot.domain.User;

import java.util.Optional;

public interface BaseUserService<T extends User> {

    boolean existsByUsername(String username);

    Optional<T> findByUsername(String username);

}
