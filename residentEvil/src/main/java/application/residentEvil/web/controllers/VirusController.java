package application.residentEvil.web.controllers;

import application.residentEvil.domain.models.bindingModels.VirusAddBindingModel;
import application.residentEvil.domain.models.viewModels.CapitalListViewModel;
import application.residentEvil.service.CapitalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
public class VirusController {

    private final CapitalService capitalService;
    private final ModelMapper modelMapper;

    @Autowired
    public VirusController(CapitalService capitalService, ModelMapper modelMapper) {
        this.capitalService = capitalService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView, @ModelAttribute(name = "bindingModel") VirusAddBindingModel bindingModel) {

        modelAndView.addObject("bindingModel", bindingModel);
        modelAndView.addObject("capitalNames", this.capitalService.findAllCapitalsSorted());
        modelAndView.addObject("capitals", this.capitalService
                .findAllCapitals()
                .stream()
                .map(c -> this.modelMapper.map(c, CapitalListViewModel.class))
                .collect(Collectors.toList()));
        modelAndView.setViewName("add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addConfirm(@Valid @ModelAttribute(name = "bindingModel") VirusAddBindingModel bindingModel,
                                   BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("bindingModel", bindingModel);
            modelAndView.setViewName("add");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/");
        return modelAndView;

    }
}
