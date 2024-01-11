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
public class AddressSimpleProjection implements Serializable {

    private String address;

    private String postalCode;

    @Override
    public String toString() {
        return "AddressSimpleProjection{" +
                "address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
