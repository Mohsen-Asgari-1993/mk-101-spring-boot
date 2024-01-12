package ir.maktabsharif101.springboot.firstspringboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegistrationDTO implements Serializable {

    @NotBlank
    @Pattern(regexp = "^09\\d{9}$")
    private String mobileNumber;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @NotBlank
//    @Size(min = 10, max = 10)
    @Pattern(regexp = "^\\d{10}$")
    private String nationalCode;

    @NotBlank
    @Size(min = 8)
    private String password;
}
