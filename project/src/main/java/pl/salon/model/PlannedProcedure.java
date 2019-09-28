package pl.salon.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planned_procedures")
public class PlannedProcedure extends AbstractEntity {
    @ManyToMany
    @Column(name = "procedure")
    private List<CosmeticProcedure> cosmeticProcedure = new ArrayList<>();
    @ManyToOne
    private Client client;
    @Column(name = "date")
    private LocalDateTime dateAndTimeOfProcedure;


    public List<CosmeticProcedure> getCosmeticProcedure() {
        return cosmeticProcedure;
    }

    public void setCosmeticProcedure(List<CosmeticProcedure> cosmeticProcedure) {
        this.cosmeticProcedure = cosmeticProcedure;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public LocalDateTime getDateAndTimeOfProcedure() {
        return dateAndTimeOfProcedure;
    }

    public void setDateAndTimeOfProcedure(LocalDateTime dateAndTimeOfProcedure) {
        this.dateAndTimeOfProcedure = dateAndTimeOfProcedure;
    }

    @Override
    public String toString() {
        return "PlannedProcedure{" +
                "cosmeticProcedure=" + cosmeticProcedure +
                ", client=" + client +
                ", dateAndTimeOfProcedure=" + dateAndTimeOfProcedure +
                "} " + super.toString();
    }
}
