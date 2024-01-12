package ir.maktabsharif101.springboot.firstspringboot.service.impl;

import ir.maktabsharif101.springboot.firstspringboot.domain.Role;
import ir.maktabsharif101.springboot.firstspringboot.repository.RoleRepository;
import ir.maktabsharif101.springboot.firstspringboot.service.PermissionService;
import ir.maktabsharif101.springboot.firstspringboot.service.RoleService;
import ir.maktabsharif101.springboot.firstspringboot.statics.RoleNames;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private final RoleRepository baseRepository;

    private final PermissionService permissionService;

    @PostConstruct
    @Transactional
    public void init() {
        if (baseRepository.count() == 0 /*&& permissionService.count() != 0*/) {
            baseRepository.save(
                    new Role(
                            RoleNames.ADMIN,
                            new HashSet<>(
                                    permissionService.findAll()
                            )
                    )
            );
        }
    }

    @Override
    public Optional<Role> findByName(String name) {
        return baseRepository.findByName(name);
    }
}
