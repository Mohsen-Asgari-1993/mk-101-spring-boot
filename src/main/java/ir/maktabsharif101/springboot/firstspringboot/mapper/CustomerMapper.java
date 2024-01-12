package ir.maktabsharif101.springboot.firstspringboot.mapper;

import ir.maktabsharif101.springboot.firstspringboot.domain.Customer;
import ir.maktabsharif101.springboot.firstspringboot.dto.CustomerCardboardDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerCardboardDTO convertToDTO(Customer customer);

    Customer convertToEntity(CustomerCardboardDTO dto);

}
