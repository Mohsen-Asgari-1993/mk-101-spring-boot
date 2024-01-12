package ir.maktabsharif101.springboot.firstspringboot.service;

import ir.maktabsharif101.springboot.firstspringboot.domain.Customer;
import ir.maktabsharif101.springboot.firstspringboot.dto.CustomerRegistrationDTO;
import ir.maktabsharif101.springboot.firstspringboot.dto.LegalCustomerRegistrationDTO;

public interface CustomerService extends BaseUserService<Customer> {

    void registerRealCustomer(CustomerRegistrationDTO registrationDTO);

    void registerLegalCustomer(LegalCustomerRegistrationDTO registrationDTO);
}
