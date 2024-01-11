package ir.maktabsharif101.springboot.firstspringboot.repository;

import ir.maktabsharif101.base.datajpa.repository.BaseEntityRepository;
import ir.maktabsharif101.springboot.firstspringboot.domain.Address;
import ir.maktabsharif101.springboot.firstspringboot.dto.projection.AddressCustomerIdAndIdProjection;
import ir.maktabsharif101.springboot.firstspringboot.dto.projection.AddressSimpleProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends BaseEntityRepository<Address, Long> {

    List<Address> findAllByCustomerId(Long customerId);

    @Query(value = "select a from Address a where a.customerId = :customerId")
    List<Address> findAllByCustomerIdCustom(@Param("customerId") Long customerId);

    @Query(
            value = "SELECT * FROM address WHERE customer_id = :customerId",
            nativeQuery = true
    )
    List<Address> findAllByCustomerIdNative(@Param("customerId") Long customerId);

    @Query(
            value = """
                    select
                    new ir.maktabsharif101.springboot.firstspringboot.dto.projection
                    .AddressSimpleProjection(a.address, a.postalCode)
                    from Address a
                    """
    )
    List<AddressSimpleProjection> findAllProjectionCustom();


    @Query(
            value = """
                    select
                    new ir.maktabsharif101.springboot.firstspringboot.dto.projection
                    .AddressCustomerIdAndIdProjection(a.id, a.customerId)
                    from Address a
                    """
    )
    List<AddressCustomerIdAndIdProjection> findAllProjectionCustomTwo();

//    <P> List<P> findAll(Class<P> pClass);

    <P> List<P> findAllByCustomerId(Long customerId, Class<P> pClass);

}
