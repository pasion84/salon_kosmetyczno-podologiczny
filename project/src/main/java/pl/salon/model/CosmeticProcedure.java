package pl.salon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
    @ManyToMany(mappedBy = "cosmeticProcedure")
    private List<PlannedProcedure> plannedProcedure = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<PlannedProcedure> getPlannedProcedure() {
        return plannedProcedure;
    }

    public void setPlannedProcedure(List<PlannedProcedure> plannedProcedure) {
        this.plannedProcedure = plannedProcedure;
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

    @Override
    public String toString() {
        return "CosmeticProcedure{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", durationOfProcedureInMinutes=" + durationOfProcedureInMinutes +
                "} " + super.toString();
    }
}
