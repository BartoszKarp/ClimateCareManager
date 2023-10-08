package pl.karpiu.climatecaremanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.karpiu.climatecaremanager.domain.model.Customer;
import pl.karpiu.climatecaremanager.domain.repository.CustomerRepository;
import pl.karpiu.climatecaremanager.dto.CustomerMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    public Customer createCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
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
