package ir.maktabsharif101.springboot.firstspringboot;

import ir.maktabsharif101.springboot.firstspringboot.dto.projection.AddressCustomerIdAndIdInterfaceProjection;
import ir.maktabsharif101.springboot.firstspringboot.dto.projection.AddressSimpleInterfaceProjection;
import ir.maktabsharif101.springboot.firstspringboot.repository.AddressRepository;
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

        List<AddressSimpleInterfaceProjection> addressList = addressRepository.findAllByCustomerId(
                5L,
                AddressSimpleInterfaceProjection.class
        );
        addressList.forEach(
                data -> System.out.println(
                        data.getPostalCode() + " - " + data.getAddress()
                )
        );

        List<AddressCustomerIdAndIdInterfaceProjection> addressProjList = addressRepository.findAllByCustomerId(
                5L,
                AddressCustomerIdAndIdInterfaceProjection.class
        );
        addressProjList.forEach(
                data -> System.out.println(
                        data.getId() + " - " + data.getCustomerId()
                )
        );
    }

}
