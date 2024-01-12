package ir.maktabsharif101.springboot.firstspringboot.domain;

import ir.maktabsharif101.base.datajpa.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Permission.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends BaseEntity<Long> {

    public static final String TABLE_NAME = "permissions";

    public static final String NAME = "name";

    @Column(name = NAME)
    private String name;

}
