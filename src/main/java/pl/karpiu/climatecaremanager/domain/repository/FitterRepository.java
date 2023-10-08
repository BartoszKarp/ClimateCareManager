package pl.karpiu.climatecaremanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.karpiu.climatecaremanager.domain.model.Fitter;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FitterRepository extends JpaRepository <Fitter, UUID> {

    Optional<Fitter> findByPhoneNumber(String phoneNumber);

}
