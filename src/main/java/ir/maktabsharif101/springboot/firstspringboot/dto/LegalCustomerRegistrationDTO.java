package ir.maktabsharif101.springboot.firstspringboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LegalCustomerRegistrationDTO extends CustomerRegistrationDTO {

    @NotBlank
    private String nationalId;

    @NotBlank
    private String workshopCode;

    @NotBlank
    private String economicCode;


}
