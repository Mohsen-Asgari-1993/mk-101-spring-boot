package ir.maktabsharif101.springboot.firstspringboot.service.impl;

import ir.maktabsharif101.springboot.firstspringboot.domain.Admin;
import ir.maktabsharif101.springboot.firstspringboot.domain.Role;
import ir.maktabsharif101.springboot.firstspringboot.repository.AdminRepository;
import ir.maktabsharif101.springboot.firstspringboot.service.AdminService;
import ir.maktabsharif101.springboot.firstspringboot.service.RoleService;
import ir.maktabsharif101.springboot.firstspringboot.statics.RoleNames;
import jakarta.annotation.PostConstruct;
import org.apache.commons.codec.digest.Sha2Crypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional(readOnly = true)
public class AdminServiceImpl extends BaseUserServiceImpl<Admin, AdminRepository> implements AdminService {

    public AdminServiceImpl(AdminRepository baseRepository, RoleService roleService) {
        super(baseRepository, roleService);
    }

    @PostConstruct
    @Transactional
    public void init() {
        Optional<Role> optionalRole = roleService.findByName(RoleNames.ADMIN);
        if (baseRepository.count() == 0 && optionalRole.isPresent()) {
            Admin admin = new Admin();
            admin.setFirstName("Mr");
            admin.setLastName("Admin");
            admin.setUsername("systemAdmin");
            admin.setPassword(
                    Sha2Crypt.sha256Crypt(
                            "123456789".getBytes(StandardCharsets.UTF_8)
                    )
            );
            admin.setCreateDate(
                    ZonedDateTime.now()
            );
            admin.setIsSuperAdmin(true);
            admin.setIsActive(true);
            admin.setRoles(
                    Set.of(
                            optionalRole.get()
                    )
            );
            baseRepository.save(admin);
        }
    }
}
