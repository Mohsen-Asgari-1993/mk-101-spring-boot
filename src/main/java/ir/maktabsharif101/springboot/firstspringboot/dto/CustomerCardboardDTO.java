package ir.maktabsharif101.springboot.firstspringboot.dto;

import ir.maktabsharif101.springboot.firstspringboot.domain.enumeration.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCardboardDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private CustomerType type;
}
