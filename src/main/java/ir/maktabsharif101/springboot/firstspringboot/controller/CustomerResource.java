package ir.maktabsharif101.springboot.firstspringboot.controller;

import ir.maktabsharif101.springboot.firstspringboot.domain.Customer;
import ir.maktabsharif101.springboot.firstspringboot.dto.CustomerCardboardDTO;
import ir.maktabsharif101.springboot.firstspringboot.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerService baseService;

    @GetMapping("/page")
    public ResponseEntity<Page<CustomerCardboardDTO>> findAll(Pageable pageable) {
        Page<Customer> page = baseService.findAll(pageable);
        return ResponseEntity.ok(
                page.map(this::mapToCardboardDTO)
        );
    }

    private CustomerCardboardDTO mapToCardboardDTO(Customer customer) {
        CustomerCardboardDTO dto = new CustomerCardboardDTO();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setType(customer.getType());
        return dto;
    }
}
