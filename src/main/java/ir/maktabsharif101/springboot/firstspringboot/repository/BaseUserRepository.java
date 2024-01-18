package ir.maktabsharif101.springboot.firstspringboot.repository;

import ir.maktabsharif101.base.datajpa.repository.BaseEntityRepository;
import ir.maktabsharif101.springboot.firstspringboot.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseUserRepository<T extends User> extends BaseEntityRepository<T, Long> {

    boolean existsByUsername(String username);

    //        @EntityGraph(value = User.ENTITY_GRAPH)
    @EntityGraph(attributePaths = {"roles", "roles.permissions"})
    Optional<T> findByUsername(String username);

}
