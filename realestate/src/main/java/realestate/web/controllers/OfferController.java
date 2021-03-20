package realestate.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import realestate.domain.models.bindings.OfferFindBindingModel;
import realestate.domain.models.bindings.OfferRegisterBindingsModel;
import realestate.domain.models.service.OfferServiceImpl;
import realestate.domain.models.service.OfferServiceModel;

@Controller
public class OfferController {
    private final OfferServiceImpl offerService;
    public final ModelMapper modelMapper;

    @Autowired
    public OfferController(OfferServiceImpl offerService, @Lazy ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/reg")
    public String register(){
        return "register.html";
    }

    @PostMapping("/reg")
    public String registerConfirm(@ModelAttribute(name="model") OfferRegisterBindingsModel model){
        try {
            this.offerService.registerOffer(this.modelMapper.map(model, OfferServiceModel.class));
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
            return "redirect:/reg";
        }

        return "redirect:/";
    }
    @GetMapping("/find")
    public String find(){
        return "find.html";
    }

    @PostMapping("/find")
    public String findConfirm(@ModelAttribute(name="model")OfferFindBindingModel model){
        try {
            this.offerService.findOffer(model);
        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
            return "redirect:/find";
        }

        return "redirect:/";
    }
}
