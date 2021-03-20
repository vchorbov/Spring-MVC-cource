package realestate.domain.models.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import realestate.domain.entities.Offer;
import realestate.domain.models.bindings.OfferFindBindingModel;
import realestate.repository.OfferRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

// Annotation for IoC
@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final Validator validator;
    private final ModelMapper modelMapper;


    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, Validator validator, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.validator = validator;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerOffer(OfferServiceModel offerServiceModel) {
        if (this.validator.validate(offerServiceModel).size() != 0) {
            throw new IllegalArgumentException("Something went wrong! A Constraint violation has taken place.");
        }

        this.offerRepository.saveAndFlush(this.modelMapper.map(offerServiceModel, Offer.class));
    }

    @Override
    public List<OfferServiceModel> findAllOffers() {
        return this.offerRepository.findAll()
                .stream()
                .map(o -> modelMapper.map(o, OfferServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void findOffer(OfferFindBindingModel offerFindBindingModel) {
        // validation of the model
        if (this.validator.validate(offerFindBindingModel).size() != 0) {
            throw new IllegalArgumentException("Something went wrong!  A Constraint violation has taken place.");
        }


        Offer offer = this.findAllOffers()
                .stream()
                .filter(o -> o.getApartmentType()
                        .equalsIgnoreCase(offerFindBindingModel.getFamilyApartmentType()))
                .filter(o -> {
                    BigDecimal rent = o.getApartmentRent();
                    BigDecimal commission = o.getAgencyCommission();
                    BigDecimal totalCost = rent.add((rent.multiply(commission))
                            .divide(new BigDecimal("100")));
                    return (totalCost.compareTo(offerFindBindingModel.getFamilyBudget()) == -1);
                })
                .findFirst()
                .map(o -> this.modelMapper.map(o, Offer.class))
                .orElse(null);

        if (offer == null) {
           throw new IllegalArgumentException("No matching offer has been found!");
        }


        this.offerRepository.delete(offer);
    }

}
