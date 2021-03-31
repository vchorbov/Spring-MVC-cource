package application.residentEvil.service;

import application.residentEvil.domain.entities.Capital;
import application.residentEvil.domain.models.serviceModels.CapitalServiceModel;
import application.residentEvil.repository.CapitalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CapitalsServiceImpl implements CapitalService {

    private final CapitalRepository capitalRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CapitalsServiceImpl(CapitalRepository capitalRepository, ModelMapper modelMapper) {
        this.capitalRepository = capitalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CapitalServiceModel> findAllCapitals() {
        return this.capitalRepository
                .findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, CapitalServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllCapitalsSorted() {
        return this.capitalRepository
                .findAllBYOrderName()
                .stream()
                .map(capital -> this.modelMapper.map(capital, CapitalServiceModel.class))
                .map(capitalServiceModel -> capitalServiceModel.getName())
                .collect(Collectors.toList());
    }
}


