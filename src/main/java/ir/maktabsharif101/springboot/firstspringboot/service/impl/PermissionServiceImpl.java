package ir.maktabsharif101.springboot.firstspringboot.service.impl;

import ir.maktabsharif101.springboot.firstspringboot.domain.Permission;
import ir.maktabsharif101.springboot.firstspringboot.repository.PermissionRepository;
import ir.maktabsharif101.springboot.firstspringboot.service.PermissionService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository baseRepository;

    @PostConstruct
    @Transactional
    public void init() {
        if (baseRepository.count() == 0) {
            baseRepository.save(
                    new Permission(
                            "readall"
                    )
            );
        }
    }

    @Override
    public List<Permission> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public long count() {
        return baseRepository.count();
    }
}
