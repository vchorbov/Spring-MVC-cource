package application.residentEvil.service;

import application.residentEvil.domain.entities.Virus;
import application.residentEvil.domain.models.bindingModels.VirusAddBindingModel;
import application.residentEvil.repository.VirusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VirusServiceImpl implements VirusService {
    private final ModelMapper modelMapper;
    private final VirusRepository virusRepository;

    @Autowired
    public VirusServiceImpl(ModelMapper modelMapper, VirusRepository virusRepository) {
        this.modelMapper = modelMapper;
        this.virusRepository = virusRepository;

    }

    @Override
    public boolean spread(VirusAddBindingModel virusAddBindingModel) {
      Virus spreadVirus = this.virusRepository.save(this.modelMapper.map(virusAddBindingModel, Virus.class));
        return true;
    }

    @Override
    public List<VirusAddBindingModel> getAllAddedViruses() {
       return this.virusRepository
               .findAll()
               .stream()
               .map(virus -> this.modelMapper.map(virus, VirusAddBindingModel.class))
               .collect(Collectors.toList());
    }

    @Override
    public boolean eradicateVirus(VirusAddBindingModel virusAddBindingModel) {
       return true;
    }

}
