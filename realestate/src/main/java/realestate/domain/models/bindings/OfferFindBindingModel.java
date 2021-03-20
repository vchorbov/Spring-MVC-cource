package realestate.domain.models.bindings;

import org.springframework.lang.NonNull;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class OfferFindBindingModel {
    // the names of the fields MUST be identical to the names
    // from the find-form
    private BigDecimal familyBudget;
    private String familyApartmentType;
    private String familyName;

    public OfferFindBindingModel() {

    }

    /* normally the validation takes place in the serviceModel
     * and the Service works with the ServiceModel
     * the BindingModel is a plane old DTO and contains no logic
     * its function is to map the input to an object
     */
    @NonNull
    @DecimalMin("0.0001")
    public BigDecimal getFamilyBudget() {
        return familyBudget;
    }

    public void setFamilyBudget(BigDecimal familyBudget) {
        this.familyBudget = familyBudget;
    }

    @NonNull
    @NotEmpty
    public String getFamilyApartmentType() {
        return familyApartmentType;
    }

    public void setFamilyApartmentType(String familyApartmentType) {
        this.familyApartmentType = familyApartmentType;
    }
    @NonNull
    @NotEmpty
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
