package ir.maktabsharif101.springboot.firstspringboot;

import ir.maktabsharif101.springboot.firstspringboot.repository.AddressRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FirstSpringBootApplication.class, args);

        AddressRepository addressRepository = run.getBean(
                AddressRepository.class
        );

        System.out.println(
                addressRepository.findAllByCustomerIdNative(1700L).size()
        );
    }

}
