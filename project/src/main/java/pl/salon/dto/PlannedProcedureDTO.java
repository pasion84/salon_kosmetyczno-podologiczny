package pl.salon.dto;

import pl.salon.model.Client;
import pl.salon.model.CosmeticProcedure;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlannedProcedureDTO {

    private List<CosmeticProcedure> cosmeticProcedure = new ArrayList<>();
    private Client client;
    private LocalDateTime dateAndTimeOfProcedure;
    private LocalDateTime createdTime;

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

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
