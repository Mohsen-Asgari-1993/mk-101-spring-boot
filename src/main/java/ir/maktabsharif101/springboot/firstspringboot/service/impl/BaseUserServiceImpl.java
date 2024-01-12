package ir.maktabsharif101.springboot.firstspringboot.service.impl;

import ir.maktabsharif101.springboot.firstspringboot.domain.User;
import ir.maktabsharif101.springboot.firstspringboot.repository.BaseUserRepository;
import ir.maktabsharif101.springboot.firstspringboot.service.BaseUserService;
import ir.maktabsharif101.springboot.firstspringboot.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BaseUserServiceImpl<T extends User, R extends BaseUserRepository<T>> implements BaseUserService<T> {

    protected final R baseRepository;

    protected final RoleService roleService;

    @Override
    public boolean existsByUsername(String username) {
        return baseRepository.existsByUsername(username);
    }

    @Override
    public Optional<T> findByUsername(String username) {
        return baseRepository.findByUsername(username);
    }

}
