package ir.maktabsharif101.springboot.firstspringboot.dto.projection;

import java.io.Serializable;

public interface AddressSimpleInterfaceProjection extends Serializable {

    String getAddress();

    String getPostalCode();

}
