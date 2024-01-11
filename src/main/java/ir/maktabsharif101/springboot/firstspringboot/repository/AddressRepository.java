package ir.maktabsharif101.springboot.firstspringboot.repository;

import ir.maktabsharif101.springboot.firstspringboot.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends
        JpaRepository<Address, Long>, JpaSpecificationExecutor<Address> {

    List<Address> findAllByCustomerId(Long customerId);

    @Query(value = "select a from Address a where a.customerId = :customerId")
    List<Address> findAllByCustomerIdCustom(@Param("customerId") Long customerId);

    @Query(
            value = "SELECT * FROM address WHERE customer_id = :customerId",
            nativeQuery = true
    )
    List<Address> findAllByCustomerIdNative(@Param("customerId") Long customerId);

}
