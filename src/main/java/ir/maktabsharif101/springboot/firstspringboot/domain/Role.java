package ir.maktabsharif101.springboot.firstspringboot.domain;

import ir.maktabsharif101.base.datajpa.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Role.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity<Long> {

    public static final String TABLE_NAME = "roles";

    public static final String NAME = "name";
    public static final String PERMISSIONS_JOIN_TABLE = "roles_permissions";

    @Column(name = NAME, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = PERMISSIONS_JOIN_TABLE
    )
    private Set<Permission> permissions = new HashSet<>();

}
