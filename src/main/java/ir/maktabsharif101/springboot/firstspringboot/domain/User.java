package ir.maktabsharif101.springboot.firstspringboot.domain;

import ir.maktabsharif101.base.datajpa.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraphs(
        value = {
                @NamedEntityGraph(
                        name = User.ENTITY_GRAPH,
                        attributeNodes = {
                                @NamedAttributeNode(value = "roles", subgraph = "roles_subgraph")
                        },
                        subgraphs = {
                                @NamedSubgraph(
                                        name = "roles_subgraph",
                                        attributeNodes = {
                                                @NamedAttributeNode(
                                                        value = "permissions"
                                                ),
                                        }
                                )
                        }
                )
        }
)
public class User extends BaseEntity<Long> {

    public static final String TABLE_NAME = "users";
    public static final String ENTITY_GRAPH = "user_entity_graph";

    public static final String ROLES_JOIN_TABLE = "users_roles";

    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USERNAME = "username";
    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String NATIONAL_CODE = "national_code";
    public static final String CREATE_DATE = "create_date";
    public static final String LAST_UPDATE_DATE = "last_update_date";
    public static final String IS_ACTIVE = "is_active";

    @Column(name = FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = LAST_NAME, nullable = false)
    private String lastName;

    @Column(name = USERNAME, nullable = false)
    private String username;

    @Column(name = MOBILE_NUMBER)
    private String mobileNumber;

    @Column(name = PASSWORD, nullable = false)
    private String password;

    @Column(name = EMAIL)
    private String email;

    @Column(name = NATIONAL_CODE)
    private String nationalCode;

    @Column(name = CREATE_DATE)
    private ZonedDateTime createDate = ZonedDateTime.now();

    @Column(name = LAST_UPDATE_DATE)
    private ZonedDateTime lastUpdateDate;

    @Column(name = IS_ACTIVE)
    private Boolean isActive = true;

    @ManyToMany
    @JoinTable(
            name = ROLES_JOIN_TABLE
    )
    private Set<Role> roles = new HashSet<>();

}
