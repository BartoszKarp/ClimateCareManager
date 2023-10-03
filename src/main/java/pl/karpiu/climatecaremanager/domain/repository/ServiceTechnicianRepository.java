package pl.karpiu.climatecaremanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.karpiu.climatecaremanager.domain.model.ServiceTechnician;

import java.util.UUID;

@Repository
public interface ServiceTechnicianRepository extends JpaRepository <ServiceTechnician, UUID> {

}
