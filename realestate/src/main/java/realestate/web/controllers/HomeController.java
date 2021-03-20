package realestate.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import realestate.domain.models.service.OfferService;
import realestate.domain.models.view.OfferViewModel;
import realestate.util.HtmlReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final OfferService offerService;
    private final HtmlReader htmlReader;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(OfferService offerService, HtmlReader htmlReader, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.htmlReader = htmlReader;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    @ResponseBody
    public String index(){
        try {

            return  prepareHtml();

        }catch (IOException ioe){
            ioe.printStackTrace();
            System.err.println("There was a problem with creating the initial html for the view.");
        }
        return "";
    }

    private String prepareHtml() throws IOException {

        List<OfferViewModel> offers = this.offerService
                .findAllOffers()
                .stream()
                .map(o -> this.modelMapper.map(o, OfferViewModel.class))
                .collect(Collectors.toList());

        StringBuilder offersHtml = new StringBuilder();
        if (offers.size() == 0){
            offersHtml.append("<div class=\"apartmentNO\">");
            offersHtml.append("There are no offers!");
            offersHtml.append("</div>");

        }else{
        for (OfferViewModel ovm : offers) {
             offersHtml.append("<div class=\"apartment\">");
             offersHtml.append("<p>Rent:" + ovm.getApartmentRent()+ "</p>");
             offersHtml.append("<p>Type: "+ ovm.getApartmentType() +"</p>");
             offersHtml.append("<p>Commission: " + ovm.getApartmentRent() + "</p>");
             offersHtml.append("</div>");
             offersHtml.append(System.lineSeparator()); // that way the line separation is OS-independent

        }
    }

        // this is the absolute path to the index.html file, which is specific for my machine and should be adjusted, if used elsewhere
        return this.htmlReader.readerHtmlFile

                ("C:\\Users\\Vili\\Desktop\\Excercises-Spring-MVC\\01. Spring Boot Introduction\\realestate\\src\\main\\resources\\static\\index.html")
                .replace("{{offers}}", offersHtml.toString().trim());

    }

/*  <div id="building"></div>
    <div class="apartment">
	<p>Rent: 700.00</p>
	<p>Type: Two Room apartment</p>
	<p>Commission: 50.00</p>
	</div>
   */
}
