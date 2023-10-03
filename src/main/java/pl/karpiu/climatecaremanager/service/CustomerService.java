package pl.karpiu.climatecaremanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.karpiu.climatecaremanager.domain.model.Customer;
import pl.karpiu.climatecaremanager.domain.repository.CustomerRepository;
import pl.karpiu.climatecaremanager.dto.CustomerDto;
import pl.karpiu.climatecaremanager.dto.CustomerMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public CustomerDto createCustomer(CustomerDto customerDto) {

       /* String firstName = customerDto.getFirstName();
        String lastName = customerDto.getLastName();
        String phoneNumber = customerDto.getPhoneNumber();

        if(isCustomerExist(firstName, lastName, phoneNumber)){
            throw new ApiException("Customer with the same phone number already exists.");
        }*/
        Customer customerToSave = new Customer();
        customerToSave.setFirstName(customerDto.getFirstName());
        customerToSave.setLastName(customerDto.getLastName());
        customerToSave.setAddress(customerDto.getAddress());
        customerToSave.setCity(customerDto.getCity());
        customerToSave.setPhoneNumber(customerDto.getPhoneNumber());
        customerToSave.setEmail(customerDto.getEmail());

        customerRepository.save(customerToSave);

        return customerMapper.mapCustomerEntityToCustomerDto(customerToSave);

    }

    @Transactional(readOnly = true)
    public List<CustomerDto> getCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::mapCustomerEntityToCustomerDto)
                .collect(Collectors.toList());
    }

    public Customer getCustomerById(UUID id){
        return customerRepository.findCustomerById(id).get();
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(UUID id){
        customerRepository.delete(getCustomerById(id));
    }

}
