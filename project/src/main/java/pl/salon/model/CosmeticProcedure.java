package pl.salon.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cosmetic_procedures")
public class CosmeticProcedure extends AbstractEntity {

    @Column(nullable = false, unique = true, name = "procedure_name")
    private String name;
    @Column(nullable = false, name = "procedure_price")
    private Double price;
    @Column(nullable = false, name = "procedure_duration")
    private Integer durationOfProcedureInMinutes;
    @ManyToMany(mappedBy = "cosmeticProcedureList")
    private List<PlannedProcedure> plannedProcedure = new ArrayList<>();

    public List<PlannedProcedure> getPlannedProcedure() {
        return plannedProcedure;
    }

    public void setPlannedProcedure(List<PlannedProcedure> plannedProcedure) {
        this.plannedProcedure = plannedProcedure;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDurationOfProcedureInMinutes() {
        return durationOfProcedureInMinutes;
    }

    public void setDurationOfProcedureInMinutes(Integer durationOfProcedureInMinutes) {
        this.durationOfProcedureInMinutes = durationOfProcedureInMinutes;
    }

}
