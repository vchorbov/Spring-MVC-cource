package application.residentEvil.domain.models.serviceModels;

import application.residentEvil.domain.entities.CreatorEnum;
import application.residentEvil.domain.entities.MagnitudeEnum;
import application.residentEvil.domain.entities.Mutation;

import java.time.LocalDate;
import java.util.List;

public class VirusAddServiceModel {
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

    public VirusAddServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public CreatorEnum getCreatorEnum() {
        return creatorEnum;
    }

    public void setCreatorEnum(CreatorEnum creatorEnum) {
        this.creatorEnum = creatorEnum;
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

    public MagnitudeEnum getMagnitudeEnum() {
        return magnitudeEnum;
    }

    public void setMagnitudeEnum(MagnitudeEnum magnitudeEnum) {
        this.magnitudeEnum = magnitudeEnum;
    }

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
