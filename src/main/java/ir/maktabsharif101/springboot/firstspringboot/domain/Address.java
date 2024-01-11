package ir.maktabsharif101.springboot.firstspringboot.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(
        name = Address.TABLE_NAME,
        indexes = {
                @Index(
                        name = "address_customer_id_index",
                        columnList = Address.CUSTOMER_ID
                )
        }
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    public static final String TABLE_NAME = "address";

    public static final String ADDRESS = "address";
    public static final String POSTAL_CODE = "postal_code";
    public static final String CUSTOMER_ID = "customer_id";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = ADDRESS)
    private String address;

    @Column(name = POSTAL_CODE)
    private String postalCode;

    @Column(name = CUSTOMER_ID, nullable = false)
    private Long customerId;

}
