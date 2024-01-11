package ir.maktabsharif101.springboot.firstspringboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfoDTO implements Serializable {

    private Integer id;

    private String firstName;

    @NotBlank
    private String lastName;
}
