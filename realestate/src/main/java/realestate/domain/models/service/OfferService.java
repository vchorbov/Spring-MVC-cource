package realestate.domain.models.service;

import realestate.domain.entities.Offer;
import realestate.domain.models.bindings.OfferFindBindingModel;

import java.util.List;

public interface OfferService {
    void registerOffer(OfferServiceModel offerServiceModel);

    List<OfferServiceModel> findAllOffers();

    void findOffer(OfferFindBindingModel offerFindBindingModel);

 }
