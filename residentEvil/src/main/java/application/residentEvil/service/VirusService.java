package application.residentEvil.service;

import application.residentEvil.domain.entities.Virus;
import application.residentEvil.domain.models.bindingModels.VirusAddBindingModel;

import java.util.List;

public interface VirusService {
    boolean spread(VirusAddBindingModel virusAddBindingModel);
    List<VirusAddBindingModel> getAllAddedViruses();
    boolean eradicateVirus(String id);
    boolean eradicateVirusByName(String name);

}
