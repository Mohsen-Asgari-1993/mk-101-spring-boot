package ir.maktabsharif101.springboot.firstspringboot;

import ir.maktabsharif101.springboot.firstspringboot.domain.Address;
import ir.maktabsharif101.springboot.firstspringboot.repository.AddressRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class FirstSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FirstSpringBootApplication.class, args);

        AddressRepository addressRepository = run.getBean(
                AddressRepository.class
        );

        Page<Address> page = addressRepository.findAll(
                PageRequest.of(
                        0, 4,
                        Sort.by("customerId")
                )
        );

        System.out.println(
                "page totalElements: " + page.getTotalElements()
        );

        System.out.println(
                "page totalPages: " + page.getTotalPages()
        );

        System.out.println(
                "page content: " + page.getContent().get(0).getId()
        );


    }

}
