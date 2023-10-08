package pl.karpiu.climatecaremanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.karpiu.climatecaremanager.domain.model.Customer;
import pl.karpiu.climatecaremanager.dto.CustomerDtoWithoutId;
import pl.karpiu.climatecaremanager.dto.CustomerNameDto;
import pl.karpiu.climatecaremanager.service.CustomerService;

import java.util.List;
import java.util.UUID;

import static pl.karpiu.climatecaremanager.dto.CustomerDtoMapper.*;

@RestController
@RequestMapping(path = "api/v1")
@RequiredArgsConstructor
public class CustomerApiController {

    private final CustomerService customerService;

    @GetMapping(path = "/customers")
    public List<CustomerDtoWithoutId> getCustomers(){
        return mapCustomerToCustomerWithoutId(customerService.getCustomers());
    }

    @GetMapping(path = "/customers/names")
    public List<CustomerNameDto> getCustomersNames(){
        return mapCustomerToCustomerNameDto(customerService.getCustomers());
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable UUID id){
        return customerService.getCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void CustomerDtoWithoutId(@RequestBody CustomerDtoWithoutId customerDtoWithoutId){
        customerService.createCustomer(mapToCustomerWithoudId(customerDtoWithoutId));
    }

    @PutMapping("/customers/{id}")
    public void updateCustomer(@PathVariable UUID id, @RequestBody CustomerDtoWithoutId  customerDtoWithoutId){
        customerService.updateCustomer(mapToCustomerWithId(id, customerDtoWithoutId));
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID id){
        customerService.deleteCustomer(id);
    }
}
