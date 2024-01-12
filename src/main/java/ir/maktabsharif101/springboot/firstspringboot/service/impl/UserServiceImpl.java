package ir.maktabsharif101.springboot.firstspringboot.service.impl;

import ir.maktabsharif101.springboot.firstspringboot.domain.User;
import ir.maktabsharif101.springboot.firstspringboot.repository.UserRepository;
import ir.maktabsharif101.springboot.firstspringboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseUserServiceImpl<User, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository baseRepository) {
        super(baseRepository);
    }
}
