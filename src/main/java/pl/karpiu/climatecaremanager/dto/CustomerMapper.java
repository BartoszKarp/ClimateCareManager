package pl.karpiu.climatecaremanager.dto;

import org.mapstruct.Mapper;
import pl.karpiu.climatecaremanager.domain.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto mapCustomerEntityToCustomerDto(Customer customer);
}
