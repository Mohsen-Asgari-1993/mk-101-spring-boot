package ir.maktabsharif101.springboot.firstspringboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ir.maktabsharif101.springboot.firstspringboot.dto.CustomerRegistrationDTO;
import ir.maktabsharif101.springboot.firstspringboot.dto.ErrorDTO;
import ir.maktabsharif101.springboot.firstspringboot.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ns/api")
@RequiredArgsConstructor
public class NotSecureResource {

    private final CustomerService customerService;

    @PostMapping("/customer/real")
    @Operation(
            summary = "this is api is for real customer registration",
            responses = {
                    @ApiResponse(responseCode = "200", description = "registration completed"),
                    @ApiResponse(
                            responseCode = "409", description = "duplicate mobileNumber",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDTO.class)
                            )
                    )
            }
    )
    public ResponseEntity<?> registerRealCustomer(@RequestBody @Valid CustomerRegistrationDTO registrationDTO) {
        customerService.registerRealCustomer(registrationDTO);
        return ResponseEntity.ok().build();
    }
}
