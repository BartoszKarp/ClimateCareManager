package pl.karpiu.climatecaremanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.karpiu.climatecaremanager.domain.model.Customer;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, UUID> {

    Optional<Customer> findByPhoneNumber(String phoneNumber);
    Optional<Customer> findByFirstName(String firstName);
    Optional<Customer> findByLastName(String lastName);

    Optional<Customer> findCustomerById(UUID id);
}
