package ir.maktabsharif101.springboot.firstspringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MobileNumberDTO implements Serializable {

    @NotBlank
    @Pattern(regexp = "^09\\d{9}$")
    private String mobileNumber;
}
