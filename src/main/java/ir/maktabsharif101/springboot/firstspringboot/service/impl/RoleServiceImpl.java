package ir.maktabsharif101.springboot.firstspringboot.service.impl;

import ir.maktabsharif101.springboot.firstspringboot.repository.RoleRepository;
import ir.maktabsharif101.springboot.firstspringboot.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private final RoleRepository baseRepository;
}
