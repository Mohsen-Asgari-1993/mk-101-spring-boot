package ir.maktabsharif101.springboot.firstspringboot.controller;

import ir.maktabsharif101.springboot.firstspringboot.domain.Customer;
import ir.maktabsharif101.springboot.firstspringboot.dto.CustomerCardboardDTO;
import ir.maktabsharif101.springboot.firstspringboot.mapper.CustomerMapper;
import ir.maktabsharif101.springboot.firstspringboot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerService baseService;

    private final CustomerMapper mapper;

    @GetMapping("/page")
    public ResponseEntity<Page<CustomerCardboardDTO>> findAll(Pageable pageable, Authentication authentication) {
        Page<Customer> page = baseService.findAll(pageable);
        return ResponseEntity.ok(
                page.map(mapper::convertToDTO)
        );
    }
}
