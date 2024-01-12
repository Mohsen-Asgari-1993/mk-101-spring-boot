package ir.maktabsharif101.springboot.firstspringboot.domain;

import ir.maktabsharif101.springboot.firstspringboot.domain.enumeration.CustomerType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    public static final String TYPE = "type";
    public static final String NATIONAL_ID = "national_id";
    public static final String WORKSHOP_CODE = "workshop_code";
    public static final String ECONOMIC_CODE = "economic_code";

    @Column(name = TYPE)
    @Enumerated(EnumType.STRING)
    private CustomerType type;

    @Column(name = NATIONAL_ID)
    private String nationalId;

    @Column(name = WORKSHOP_CODE)
    private String workshopCode;

    @Column(name = ECONOMIC_CODE)
    private String economicCode;

}
