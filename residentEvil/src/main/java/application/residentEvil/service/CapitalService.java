package application.residentEvil.service;

import application.residentEvil.domain.models.serviceModels.CapitalServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CapitalService {
    List<CapitalServiceModel> findAllCapitals();
    List<String> findAllCapitalsSorted();
}
