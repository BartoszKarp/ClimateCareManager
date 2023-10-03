package pl.karpiu.climatecaremanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.karpiu.climatecaremanager.domain.model.Customer;
import pl.karpiu.climatecaremanager.domain.model.Trader;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TraderRepository extends JpaRepository <Trader, UUID> {

    Optional<Trader> findByPhoneNumber(String phoneNumber);
}
