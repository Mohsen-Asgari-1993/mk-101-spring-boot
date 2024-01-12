package ir.maktabsharif101.springboot.firstspringboot.service;

import ir.maktabsharif101.springboot.firstspringboot.domain.Role;

import java.util.Optional;

public interface RoleService {

    Optional<Role> findByName(String name);

}
