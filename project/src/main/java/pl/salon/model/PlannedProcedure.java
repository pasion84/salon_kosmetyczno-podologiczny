package pl.salon.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planned_procedures")
public class PlannedProcedure extends AbstractEntity {
    @ManyToOne
    private CosmeticProcedure cosmeticProcedure;
    @ManyToOne
    private Client client;
    @Column(name = "date")
    private LocalDateTime dateAndTimeOfProcedure;
    @Column(name = "created_time")
    private LocalDateTime createdTime;
    @ManyToOne
    private Client worker;

//    public List<PlannedProcedure> addProcedureToSchedule(CosmeticProcedure cosmeticProcedureList){
//        List<PlannedProcedure> plannedProcedureList = new ArrayList<>();
//        return plannedProcedureList.add(cosmeticProcedureList.getId());
//    }

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

//    public List<CosmeticProcedure> getCosmeticProcedure() {
//        return cosmeticProcedure;
//    }
//
//    public void setCosmeticProcedure(List<CosmeticProcedure> cosmeticProcedure) {
//        this.cosmeticProcedure = cosmeticProcedure;
//    }


    public CosmeticProcedure getCosmeticProcedure() {
        return cosmeticProcedure;
    }

    public void setCosmeticProcedure(CosmeticProcedure cosmeticProcedure) {
        this.cosmeticProcedure = cosmeticProcedure;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
//    public List<CosmeticProcedure> add(){
//        cosmeticProcedure.add(cosmeticProcedure.get(CosmeticProcedure.class))
//    }

    public LocalDateTime getDateAndTimeOfProcedure() {
        return dateAndTimeOfProcedure;
    }

    public void setDateAndTimeOfProcedure(LocalDateTime dateAndTimeOfProcedure) {
        this.dateAndTimeOfProcedure = dateAndTimeOfProcedure;
    }

}
