package ir.maktabsharif101.springboot.firstspringboot.service.impl;

import ir.maktabsharif101.springboot.firstspringboot.domain.Customer;
import ir.maktabsharif101.springboot.firstspringboot.domain.enumeration.CustomerType;
import ir.maktabsharif101.springboot.firstspringboot.dto.CustomerRegistrationDTO;
import ir.maktabsharif101.springboot.firstspringboot.dto.LegalCustomerRegistrationDTO;
import ir.maktabsharif101.springboot.firstspringboot.exception.GeneralRuntimeException;
import ir.maktabsharif101.springboot.firstspringboot.repository.CustomerRepository;
import ir.maktabsharif101.springboot.firstspringboot.service.CustomerService;
import ir.maktabsharif101.springboot.firstspringboot.service.RoleService;
import ir.maktabsharif101.springboot.firstspringboot.util.HashUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl extends BaseUserServiceImpl<Customer, CustomerRepository>
        implements CustomerService {

    public CustomerServiceImpl(CustomerRepository baseRepository, RoleService roleService) {
        super(baseRepository, roleService);
    }

    @Override
    @Transactional
    public void registerRealCustomer(CustomerRegistrationDTO registrationDTO) {
        checkUsernameForRegistration(registrationDTO);
        Customer customer = new Customer();
        doCommonOperationForRegistration(customer, registrationDTO);
        customer.setType(CustomerType.REAL);
//        TODO add customer role
        baseRepository.save(customer);
    }

    @Override
    @Transactional
    public void registerLegalCustomer(LegalCustomerRegistrationDTO registrationDTO) {
        checkUsernameForRegistration(registrationDTO);
        Customer customer = new Customer();
        doCommonOperationForRegistration(customer, registrationDTO);
        customer.setType(CustomerType.LEGAL);
        customer.setNationalId(registrationDTO.getNationalId());
        customer.setWorkshopCode(registrationDTO.getWorkshopCode());
        customer.setEconomicCode(registrationDTO.getEconomicCode());
        baseRepository.save(customer);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    private void doCommonOperationForRegistration(Customer customer, CustomerRegistrationDTO registrationDTO) {
        customer.setUsername(registrationDTO.getMobileNumber());
        customer.setMobileNumber(registrationDTO.getMobileNumber());
        customer.setFirstName(registrationDTO.getFirstName());
        customer.setLastName(registrationDTO.getLastName());
        customer.setEmail(registrationDTO.getEmail());
        customer.setNationalCode(registrationDTO.getNationalCode());
        customer.setPassword(
                HashUtil.hash(registrationDTO.getPassword())
        );
//        TODO add customer role
    }


    private void checkUsernameForRegistration(CustomerRegistrationDTO registrationDTO) {
        if (baseRepository.existsByUsername(registrationDTO.getMobileNumber())) {
            throw new GeneralRuntimeException(
                    "duplicate mobileNumber",
                    HttpStatus.CONFLICT
            );
        }
    }
}
