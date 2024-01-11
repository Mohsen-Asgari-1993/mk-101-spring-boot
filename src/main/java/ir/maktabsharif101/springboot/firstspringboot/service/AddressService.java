package ir.maktabsharif101.springboot.firstspringboot.service;

import ir.maktabsharif101.springboot.firstspringboot.domain.Address;
import ir.maktabsharif101.springboot.firstspringboot.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;


    public List<Address> findAllByCustomerId(Long customerId) {
//        return addressRepository.findAllByCustomerId(customerId);
        return addressRepository.findAll(
                (root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(
                                root.get("customerId"),
                                customerId
                        )
        );
    }

}
