package ir.maktabsharif101.springboot.firstspringboot;

import ir.maktabsharif101.springboot.firstspringboot.domain.Address;
import ir.maktabsharif101.springboot.firstspringboot.repository.AddressRepository;
import ir.maktabsharif101.springboot.firstspringboot.service.AddressService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class FirstSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FirstSpringBootApplication.class, args);

        AddressRepository addressRepository = run.getBean(
                AddressRepository.class
        );

        AddressService addressService = run.getBean(
                AddressService.class
        );

        List<Address> allByCustomerId = addressService.findAllByCustomerId(5L);
        System.out.println(allByCustomerId.size());


    }

}
