package application.residentEvil.domain.models.bindingModels;
import application.residentEvil.domain.entities.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class VirusAddBindingModel {

    private String name;
    private String description;
    private String sideEffects;
    private CreatorEnum creatorEnum;
    private boolean isDeadly;
    private boolean isCurable;
    private Mutation mutation;
    private Integer turnoverRate;
    private Integer hoursUntilTurn;
    private MagnitudeEnum magnitudeEnum;
    private LocalDate releaseDate;
    private List<String> capital;

    public VirusAddBindingModel() {
    }

    @NonNull
    @Size(min=3, max = 10, message = "Invalid name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Size(min=5, max=100, message = "The length of the description should be between 5 and 100 symbols")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public application.residentEvil.domain.entities.CreatorEnum getCreatorEnum() {
        return creatorEnum;
    }

    public void setCreatorEnum(application.residentEvil.domain.entities.CreatorEnum creator) {
        this.creatorEnum = creator;
    }

    public boolean isDeadly() {
        return isDeadly;
    }

    public void setDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    public boolean isCurable() {
        return isCurable;
    }

    public void setCurable(boolean curable) {
        isCurable = curable;
    }

    public Mutation getMutation() {
        return mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Integer getHoursUntilTurn() {
        return hoursUntilTurn;
    }

    public void setHoursUntilTurn(Integer hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    public application.residentEvil.domain.entities.MagnitudeEnum getMagnitudeEnum() {
        return magnitudeEnum;
    }

    public void setMagnitudeEnum(application.residentEvil.domain.entities.MagnitudeEnum magnitude) {
        this.magnitudeEnum = magnitude;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getCapital() {
        return capital;
    }

    public void setCapital(List<String> capital) {
        this.capital = capital;
    }
}
