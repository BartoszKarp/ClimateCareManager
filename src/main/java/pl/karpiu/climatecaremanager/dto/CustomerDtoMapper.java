package pl.karpiu.climatecaremanager.dto;

import pl.karpiu.climatecaremanager.domain.model.Customer;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerDtoMapper {

    public static List<CustomerNameDto> mapCustomerToCustomerNameDto(List<Customer> customers) {
        return customers.stream()
                .map(customer -> new CustomerNameDto(customer.getId(), customer.getFirstName(), customer.getLastName()))
                .collect(Collectors.toList());
    }

    public static List<CustomerDtoWithoutId> mapCustomerToCustomerWithoutId(List<Customer> customers) {
        return customers.stream()
                .map(customer -> new CustomerDtoWithoutId(customer.getFirstName(), customer.getLastName(), customer.getAddress(), customer.getCity(), customer.getCity(), customer.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    public static Customer mapToCustomerWithoudId(CustomerDtoWithoutId customerDtoWithoutId) {
        return Customer.builder()
                .firstName(customerDtoWithoutId.firstName())
                .lastName(customerDtoWithoutId.lastName())
                .address(customerDtoWithoutId.address())
                .city(customerDtoWithoutId.city())
                .address(customerDtoWithoutId.address())
                .phoneNumber(customerDtoWithoutId.phoneNumber())
                .email(customerDtoWithoutId.email())
                .build();
    }

    public static Customer mapToCustomerWithId(UUID id, CustomerDtoWithoutId customerDtoWithoutId) {
        return Customer.builder()
                .id(id)
                .firstName(customerDtoWithoutId.firstName())
                .lastName(customerDtoWithoutId.lastName())
                .address(customerDtoWithoutId.address())
                .city(customerDtoWithoutId.city())
                .address(customerDtoWithoutId.address())
                .phoneNumber(customerDtoWithoutId.phoneNumber())
                .email(customerDtoWithoutId.email())
                .build();
    }
}
