package ir.maktabsharif101.springboot.firstspringboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import ir.maktabsharif101.springboot.firstspringboot.dto.*;
import ir.maktabsharif101.springboot.firstspringboot.service.CustomerService;
import ir.maktabsharif101.springboot.firstspringboot.util.SemaphoreUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ns/api")
@RequiredArgsConstructor
@Validated
public class NotSecureResource {

    private final CustomerService customerService;

    @PostMapping("/customer/mobile-number/v1")
    @Operation(
            summary = "this is api is for check customer mobileNumber",
            description = "true means mobileNumber exists and can't use that one"
    )
    public ResponseEntity<ResultDTO<Boolean>> existsByMobileNumber(@RequestBody @Valid MobileNumberDTO dto) {
        return ResponseEntity.ok(
                new ResultDTO<>(
                        customerService.existsByUsername(dto.getMobileNumber())
                )
        );
    }

    @GetMapping("/customer/mobile-number/v2")
    @Operation(
            summary = "this is api is for check customer mobileNumber",
            description = "true means mobileNumber exists and can't use that one"
    )
    public ResponseEntity<ResultDTO<Boolean>> existsByMobileNumber(
            @RequestParam("mobileNumber") @Pattern(regexp = "^09\\d{9}$") String mobileNumber) {

        return ResponseEntity.ok(
                new ResultDTO<>(
                        customerService.existsByUsername(mobileNumber)
                )
        );
    }

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
        SemaphoreUtil.acquireCustomerRegistration();
        try {
            customerService.registerRealCustomer(registrationDTO);
            return ResponseEntity.ok().build();
        } finally {
            SemaphoreUtil.releaseCustomerRegistration();
        }
    }

    @PostMapping("/customer/legal")
    @Operation(
            summary = "this is api is for legal customer registration",
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
    public ResponseEntity<?> registerLegalCustomer(@RequestBody @Valid LegalCustomerRegistrationDTO registrationDTO) {
        SemaphoreUtil.acquireCustomerRegistration();
        try {
            customerService.registerLegalCustomer(registrationDTO);
            return ResponseEntity.ok().build();
        } finally {
            SemaphoreUtil.releaseCustomerRegistration();
        }
    }
}
