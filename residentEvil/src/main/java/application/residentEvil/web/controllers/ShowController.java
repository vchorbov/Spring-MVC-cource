package application.residentEvil.web.controllers;

import application.residentEvil.domain.models.viewModels.VirusListViewModel;
import application.residentEvil.service.VirusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ShowController {

    private ModelMapper modelMapper;
    private VirusService virusService;

    @Autowired
    public ShowController(ModelMapper modelMapper, VirusService virusService) {
        this.modelMapper = modelMapper;
        this.virusService = virusService;
    }

    @GetMapping("/show")
    public ModelAndView show(ModelAndView modelAndView) {
        List<VirusListViewModel> virusViews = this.virusService.getAllAddedViruses()
                .stream()
                .map(virusService -> this.modelMapper.map(virusService, VirusListViewModel.class))
                .collect(Collectors.toList());
        modelAndView.addObject("virusViews", virusViews);
        modelAndView.setViewName("show");
        return modelAndView;

    }

    @GetMapping(path ="/delete/{name}")
    public ModelAndView delete(@PathVariable String name, ModelAndView modelAndView) {
      boolean exists = this.virusService.eradicateVirusByName(name);
      if(!exists){
          throw new IllegalArgumentException("The virus cannot be eradicated, because it does not exist!");
      }
       this.virusService.eradicateVirusByName(name);
       modelAndView.setViewName("redirect:/show");
       return modelAndView;
    }

}
