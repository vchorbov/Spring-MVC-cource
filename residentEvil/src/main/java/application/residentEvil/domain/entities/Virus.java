package application.residentEvil.domain.entities;

import org.springframework.lang.NonNull;
import application.residentEvil.domain.entities.*;
//import application.residentEvil.domain.entities.Magnitude;




import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "viruses")
public class Virus extends BaseEntity {

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
    private List<Capital> capital;

    public Virus() {
    }

    @Column(name="name")
    @NonNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="side_effects")
    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="creator")
    public CreatorEnum getCreator() {
        return creatorEnum;
    }

    public void setCreator(CreatorEnum creatorEnum) {
        this.creatorEnum = creatorEnum;
    }

    @Column(name="is_deadly")
    public boolean isDeadly() {
        return isDeadly;
    }

    public void setDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    @Column(name="is_curable")
    public boolean isCurable() {
        return isCurable;
    }

    public void setCurable(boolean curable) {
        isCurable = curable;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="mutation")
    public Mutation getMutation() {
        return mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    @Column(name="turnover_rate")
    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    @Column(name="hours_until_turn")
    public Integer getHoursUntilTurn() {
        return hoursUntilTurn;
    }

    public void setHoursUntilTurn(Integer  hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="magnitude")
    public MagnitudeEnum getMagnitude() {
        return magnitudeEnum;
    }

    public void setMagnitude(MagnitudeEnum magnitudeEnum) {
        this.magnitudeEnum = magnitudeEnum;
    }

    @Column(name="release_date")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate  releaseDate) {
        this.releaseDate = releaseDate;
    }

    @OneToMany(targetEntity = Capital.class)
    @JoinTable(name="viruses_capitals",
             joinColumns = @JoinColumn(name="virus_id", referencedColumnName = "id"),
             inverseJoinColumns =@JoinColumn(name="capital_id", referencedColumnName = "id") )
     //@Column(name="capital")
    public List<Capital> getCapital() {

        return capital;
    }

    public void setCapital(List<Capital> capital) {

        this.capital = capital;
    }

}
