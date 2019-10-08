package pl.salon.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planned_procedures")
public class PlannedProcedure extends AbstractEntity {
    @OneToMany(mappedBy = "plannedProcedure")
    private List<CosmeticProcedure> cosmeticProcedureList = new ArrayList<>();
    @ManyToOne
    private Client client;
    @Column(name = "date")
    private LocalDateTime dateAndTimeOfProcedure;
    @Column(name = "created_time")
    private LocalDateTime createdTime;
    @ManyToOne
    private Client worker;


    public Client getWorker() {
        return worker;
    }

    public void setWorker(Client worker) {
        this.worker = worker;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public List<CosmeticProcedure> getCosmeticProcedureList() {
        return cosmeticProcedureList;
    }

    public void setCosmeticProcedureList(List<CosmeticProcedure> cosmeticProcedureList) {
        this.cosmeticProcedureList = cosmeticProcedureList;
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

}
