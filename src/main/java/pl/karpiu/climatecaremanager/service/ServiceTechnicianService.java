package pl.karpiu.climatecaremanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.karpiu.climatecaremanager.domain.repository.ServiceTechnicianRepository;

@Service
@RequiredArgsConstructor
public class ServiceTechnicianService {

    private final ServiceTechnicianRepository serviceTechnicianRepository;

}
