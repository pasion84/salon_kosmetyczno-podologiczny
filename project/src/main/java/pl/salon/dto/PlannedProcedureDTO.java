package pl.salon.dto;

import pl.salon.model.Client;
import pl.salon.model.CosmeticProcedure;
import pl.salon.model.PlannedProcedure;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlannedProcedureDTO {


    private List<CosmeticProcedure> cosmeticProcedure = new ArrayList<>();
    private Long clientId;
    private LocalDateTime dateAndTimeOfProcedure;
    private LocalDateTime createdTime;
    private String role;
    private Long cosmeticProcedureId;
    private Long workerId;
    private Client client;

    public PlannedProcedureDTO() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PlannedProcedureDTO(Long clientId) {
        this.clientId = clientId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Long getCosmeticProcedureId() {
        return cosmeticProcedureId;
    }

    public void setCosmeticProcedureId(Long cosmeticProcedureId) {
        this.cosmeticProcedureId = cosmeticProcedureId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<CosmeticProcedure> getCosmeticProcedure() {
        return cosmeticProcedure;
    }

    public void setCosmeticProcedure(List<CosmeticProcedure> cosmeticProcedure) {
        this.cosmeticProcedure = cosmeticProcedure;
    }

//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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
