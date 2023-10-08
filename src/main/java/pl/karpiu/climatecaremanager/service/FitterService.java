package pl.karpiu.climatecaremanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.karpiu.climatecaremanager.domain.repository.FitterRepository;

@Service
@RequiredArgsConstructor
public class FitterService {

    private final FitterRepository fitterRepository;

}
