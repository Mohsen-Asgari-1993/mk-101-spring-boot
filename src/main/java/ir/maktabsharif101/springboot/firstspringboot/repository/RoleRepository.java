package ir.maktabsharif101.springboot.firstspringboot.repository;

import ir.maktabsharif101.base.datajpa.repository.BaseEntityRepository;
import ir.maktabsharif101.springboot.firstspringboot.domain.Role;

import java.util.Optional;

public interface RoleRepository extends BaseEntityRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
