package ir.maktabsharif101.springboot.firstspringboot.dto.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressCustomerIdAndIdProjection implements Serializable {

    private Long id;

    private Long customerId;

    @Override
    public String toString() {
        return "AddressSimpleProjection{" +
                "address='" + id + '\'' +
                ", postalCode='" + customerId + '\'' +
                '}';
    }
}
